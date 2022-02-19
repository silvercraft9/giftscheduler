/**
 * 
 */
package core.plan;

import java.util.ArrayList;
import java.util.HashMap;

import core.association.IAssociation;
import core.exclusion.IExclusionSet;
import core.member.IMember;

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
	
	
	public ArrayList<IAssociation> generate(ArrayList<IMember> participant, IExclusionSet exclusions) {
		HashMap<IMember, Integer> availabilites = new HashMap<IMember, Integer>();
		int nbParts = participant.size();
		for(int i = 0; i < nbParts; i++) {
			IMember part = participant.get(i);
			int availability = exclusions.getNbExcludedReceivers(part);
			availabilites.put(part, availability);
		}
		return this.associations;
	}

	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}

}
