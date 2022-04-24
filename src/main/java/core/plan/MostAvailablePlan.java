/**
 * 
 */
package core.plan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import core.association.Association;
import core.association.IAssociation;
import core.exclusion.IExclusionSet;
import core.member.IMember;
import core.member.IMemberCollection;
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

	public ArrayList<IAssociation> generate() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}

}
