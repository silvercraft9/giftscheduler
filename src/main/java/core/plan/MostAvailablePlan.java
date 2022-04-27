/**
 * 
 */
package core.plan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import core.association.Association;
import core.association.IAssociation;
import core.exclusion.Exclusion;
import core.exclusion.IExclusion;
import core.exclusion.IExclusionSet;
import core.member.IMember;
import core.member.IMemberCollection;
import core.member.SimpleMemberCollection;
import core.utils.ArrayUtils;

/**
 * @author ro6k4
 * This plan relies on the availability of receivers to pair gifters with the less number of receivers first
 */
public class MostAvailablePlan implements IPlan {

	private String event;
	private ArrayList<IAssociation> associations;
	private IMemberCollection collection;
	private IExclusionSet exclusions;
	
	public MostAvailablePlan(String event, IMemberCollection collection, IExclusionSet exclusions) {
		this.event = event;
		this.associations = new ArrayList<IAssociation>();
		this.collection = collection;
		this.exclusions = exclusions;
	}
		
	public ArrayList<IMember> getAvailableReceivers(IMember member) {
		ArrayList<IMember> candidates = this.collection.getOtherMembers(member);
		ArrayList<IMember> exclRcvrs = this.exclusions.getExcludedReceivers(member);
		int nbExcl = exclRcvrs.size();
		for(int i = 0; i < nbExcl; i++) {
			IMember exRcvr = exclRcvrs.get(i);
			if(candidates.contains(exRcvr)) {
				candidates.remove(exRcvr);
			}
		}
		return candidates;
	}

	public ArrayList<IMember> getAvailableGifters(IMember member) {
		ArrayList<IMember> candidates = this.collection.getOtherMembers(member);
		ArrayList<IMember> exclGftrs = this.exclusions.getExcludedGifters(member);
		int nbExcl = exclGftrs.size();
		for(int i = 0; i < nbExcl; i++) {
			IMember exGftr = exclGftrs.get(i);
			if(candidates.contains(exGftr)) {
				candidates.remove(exGftr);
			}
		}
		return candidates;
	}

	public void generate() {
	
		ArrayList<IAssociation> assocs = new ArrayList<IAssociation>();
		
		HashMap<IMember, ArrayList<IMember>> rcvrsMap = new HashMap<IMember, ArrayList<IMember>>();
		
		ArrayList<IMember> members = this.collection.getMembers();
		int nbMember = members.size();
		for(int i = 0; i < nbMember; i++) { //affectation of the number of receivers as the score for each member
			IMember member = members.get(i);
			ArrayList<IMember> options = getAvailableReceivers(member);
			rcvrsMap.put(member, options);
			int score = options.size();
			member.setScore(score);
		}
		this.collection = new SimpleMemberCollection(members); //update collection members with scored members
		
		int j = 0;
		ArrayList<IMember> scoredMembers = this.collection.getSortAscByScore();
		int nbScMembers = scoredMembers.size();
		
		ArrayList<IMember> candidates = new ArrayList<IMember>();
		ArrayList<Integer> weights = new ArrayList<Integer>();
		
		while(j < nbScMembers) {
			IMember member = scoredMembers.get(j);
			ArrayList<IMember> options = rcvrsMap.get(member);
			
			int nbOptions = options.size();
			for(int k = 0; k < nbOptions; k++) {
				IMember candidate = options.get(k);
				int weight = this.getAvailableGifters(candidate).size(); //we want to select a candidate that is a limited choice for another gifter
				candidates.add(candidate);
				weights.add(weight);
			}
			
			if(candidates.size() == 0) {
				IAssociation assoc = assocs.get(j - 1);
				IExclusion excl = new Exclusion(assoc.getGifter(), assoc.getReceiver());
				this.exclusions.addExclusion(excl);
				assocs.remove(j - 1);
			} else {
				IMember selected = candidates.get(ArrayUtils.maxIndex(weights));
				IAssociation assoc = new Association(member, selected);
				//TODO to complete, there is an issue here
				assocs.add(assoc);
				j++;
				
			}
			
		}
		
		
	}
	
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}

}
