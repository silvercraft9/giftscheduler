package core.plan;

import java.util.ArrayList;

import core.association.IAssociation;
import core.member.IMember;

public interface IPlan {

	/**
	 * 
	 * @param member the potential gifter
	 * @return the list of potential receivers for the member
	 */
	public ArrayList<IMember> getAvailableReceivers(IMember member);
	
	/**
	 * 
	 * @param member the potential receiver
	 * @return the list of potential gifters for the member
	 */
	public ArrayList<IMember> getAvailableGifters(IMember member);
	
	/**
	 * 
	 * @return a distribution plan considering the exclusion set
	 */
	public ArrayList<IAssociation> generate();
	
	/**
	 * 
	 * @return true if the distribution plan is valid, false otherwise
	 */
	public boolean validate();
}
