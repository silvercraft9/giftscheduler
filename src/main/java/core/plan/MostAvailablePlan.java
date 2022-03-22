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
import core.utils.ArrayUtils;

/**
 * @author ro6k4
 * This plan relies on the availability of receivers to pair gifters with the less number of receivers first
 */
public class MostAvailablePlan implements IPlan {

	private String event;
	private ArrayList<IAssociation> associations;
	
	public MostAvailablePlan(String event) {
		this.event = event;
		this.associations = new ArrayList<IAssociation>();
	}
	
	
	public ArrayList<IAssociation> generate(ArrayList<IMember> participants, IExclusionSet exclusions) {
		ArrayList<IAssociation> res = new ArrayList<IAssociation>();
		ArrayList<IMember> partCopy = ArrayUtils.duplicateList(participants);
		ArrayList<IMember> sortedMembers = new ArrayList<IMember>();
		ArrayList<Integer> availabilites = new ArrayList<Integer>();
		HashMap<IMember, Integer> availMap = new HashMap<IMember, Integer>();
		int nbParts = partCopy.size();
		for(int i = 0; i < nbParts; i++) {
			IMember part = partCopy.get(i);
			int availability = exclusions.getNbExcludedReceivers(part);
			availabilites.add(availability);
			availMap.put(part, availability);
		}
		while(!partCopy.isEmpty()) {
			int lessAvailIndex = ArrayUtils.minIndex(availabilites);
			sortedMembers.add(partCopy.get(lessAvailIndex));
			partCopy.remove(lessAvailIndex);
			availabilites.remove(lessAvailIndex);
		}
		int j = 0;
		IAssociation assoc = null;
		IMember candidate = null;
		int nbAssoc = nbParts / 2;
		while(j < nbAssoc) {
			candidate = sortedMembers.get(j);
			ArrayList<IMember> availReceivers = getAvailableReceivers(candidate, exclusions, participants);
			int nbRcvs = availReceivers.size();
			if(nbRcvs == 0) {
				res.remove(j);
				j--;
			}
			Random rand = new Random();
			IMember receiver = availReceivers.get(rand.nextInt(nbRcvs));
			assoc = new Association(candidate, receiver);
			res.add(assoc);
			sortedMembers.remove(candidate);
			sortedMembers.remove(receiver);
		}
		
		
		return this.associations;
	} 

	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public ArrayList<IMember> getAvailableReceivers(IMember gifter, IExclusionSet exclusions, ArrayList<IMember> participants){
		ArrayList<IMember> res = new ArrayList<IMember>();
		ArrayList<IMember> excludedReceivers = exclusions.getExcludedReceivers(gifter);
		int size = participants.size();
		for(int i = 0; i < size; i++) {
			IMember receiver = participants.get(i);
			if(!excludedReceivers.contains(receiver) && !gifter.equals(receiver)) {
				res.add(receiver);
			}
		}
		return res;
	}

}
