package core.plan;

import java.util.ArrayList;

import core.association.IAssociation;
import core.exclusion.IExclusionSet;
import core.member.IMember;

public interface IPlan {

	/**
	 * 
	 * @param participant the list of participants to the distribution plan
	 * @param exclusions the list of exclusions to consider for the distribution plan
	 * @return a distribution plan considering the exclusion set
	 */
	public ArrayList<IAssociation> generate(ArrayList<IMember> participant, IExclusionSet exclusions);
	
	/**
	 * 
	 * @return true if the distribution plan is valid, false otherwise
	 */
	public boolean validate();
}
