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
	 * this method generates a set of associations including every member in the collection
	 */
	public void generate();
	
	/**
	 * 
	 * @return true if the distribution plan is valid, false otherwise
	 */
	public boolean validate();
}
