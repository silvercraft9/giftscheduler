package core.exclusion;

import java.util.ArrayList;

import core.member.IMember;

public interface IExclusionSet {
	
	/**
	 * 
	 * @param gifter the member offering a gift
	 * @return the number of excluded receivers for the given member
	 */
	public int getNbExcludedReceivers(IMember gifter);
	
	/**
	 * 
	 * @param receiver the member receiving a gift
	 * @return the number of excluded gifters for the given member
	 */
	public int getNbExcludedGifters(IMember receiver);

	/**
	 * 
	 * @param gifter the member offering a gift
	 * @return the list of excluded receivers for the given member
	 */
	public ArrayList<IMember> getExcludedReceivers(IMember gifter);
	
	/**
	 * 
	 * @param receiver the member receiving a gift
	 * @return the list of excluded gifters for the given member
	 */
	public ArrayList<IMember> getExcludedGifters(IMember receiver);
}
