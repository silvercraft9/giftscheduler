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
		ArrayList<IMember> gifters = ArrayUtils.duplicateList(this.collection.getMembers());
		ArrayList<IMember> receivers = new ArrayList<IMember>();
		Random rand = new Random();
		
		int nbGifters = gifters.size();
		
		for(int i = 0; i < nbGifters; i++) {
			//System.out.println("Gifters : " + ArrayUtils.memberArrayToString(gifters));
			//System.out.println("Affected receivers : " + ArrayUtils.memberArrayToString(receivers));
			
			IMember gifter = gifters.get(i);
			//System.out.println("==================================================");
			//System.out.println("Generating an association for member " + gifter.getName() + "...");
			ArrayList<IMember> candidates = this.getAvailableReceivers(gifter);
			//System.out.println("Candidates : " + ArrayUtils.memberArrayToString(candidates));
			int nbCands = candidates.size();
			boolean validReceiver = false;
			IMember candidate = null;
			
			while(!validReceiver) {
				
				int receiverIndex = rand.nextInt(nbCands);
				candidate = candidates.get(receiverIndex);
				//System.out.println("--> Trying candidate " + candidate.getName());
				if(!receivers.contains(candidate)) {
					validReceiver = true;
				} //else {
					//System.out.println("--> Invalid candidate, trying another one");
				//}
			}
			//System.out.println("--> Valid candidate found, adding association [" + gifter.getName() + " offers to " + candidate.getName() + "]");
			IAssociation assoc = new Association(gifter, candidate);
			this.associations.add(assoc);
			receivers.add(candidate);
		}
		//System.out.println("All associations found, plan generated successfully!");
	}

	public boolean validate() {
		ArrayList<IAssociation> assocs = this.associations;
		int nbAssocs = assocs.size();
		
		ArrayList<IMember> gifters = new ArrayList<IMember>();
		ArrayList<IMember> receivers = new ArrayList<IMember>();
		
		for(int i = 0; i < nbAssocs; i++) {
			IAssociation assoc = assocs.get(i);
			IMember gifter = assoc.getGifter();
			IMember receiver = assoc.getReceiver();
			
			if(!gifters.contains(gifter)) {
				gifters.add(gifter);
			}
			
			if(!receivers.contains(receiver)) {
				receivers.add(receiver);
			}
		}
		
		//A plan is valid if every member is both a gifter and a receiver
		return gifters.size() == this.collection.getMembers().size() && receivers.size() == gifters.size(); 
	}

	@Override
	public String toString() {
		String res = "Plan (Full Random strategy) : " + this.event + "\n";
		ArrayList<IAssociation> assocs = this.associations;
		int nbAssocs = assocs.size();
		for(int i = 0; i < nbAssocs; i++) {
			IAssociation assoc = assocs.get(i);
			IMember gifter = assoc.getGifter();
			IMember receiver = assoc.getReceiver();
			res += "=> " + gifter.getName() + " offers to " + receiver.getName() + "\n";
		}
		return res;
	}
}
