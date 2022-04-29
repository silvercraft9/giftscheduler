/**
 * 
 */
package core.plan;

import java.util.ArrayList;
import java.util.Random;

import core.association.Association;
import core.association.IAssociation;
import core.exclusion.IExclusionSet;
import core.member.IMember;
import core.member.IMemberCollection;
import core.utils.ArrayUtils;

/**
 * @author admin
 *
 */
public class RandomPlan implements IPlan {
	
	private String event;
	private ArrayList<IAssociation> associations;
	private IMemberCollection collection;
	private IExclusionSet exclusions;
	
	public RandomPlan(String event, IMemberCollection collection, IExclusionSet exclusions) {
		this.event = event;
		this.collection = collection;
		this.exclusions = exclusions;
		this.associations = new ArrayList<IAssociation>();
	}

	@Override
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

	@Override
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

	@Override
	public void generate() {
		ArrayList<IMember> gifters = ArrayUtils.duplicateList(this.collection.getMembers());
		ArrayList<IMember> receivers = ArrayUtils.duplicateList(this.collection.getMembers());
		Random rand = new Random();
		
		int i = 0;
		while(!gifters.isEmpty()) {
			
			int gifterIndex =  rand.nextInt(gifters.size());
			IMember gifter = gifters.get(gifterIndex);
			
			ArrayList<IMember> candidates = this.getAvailableReceivers(gifter);
			boolean validReceiver = false;
			IMember candidate = null;
			
			while(!validReceiver) {
				
				int receiverIndex = rand.nextInt(receivers.size());
				candidate = receivers.get(receiverIndex);
				if(candidates.contains(candidate)) {
					validReceiver = true;
				}
			}
			
			IAssociation assoc = new Association(gifter, candidate);
			this.associations.add(assoc);
			gifters.remove(gifter);
			receivers.remove(candidate);
			
		}
		
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}

}
