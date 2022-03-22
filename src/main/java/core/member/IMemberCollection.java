/**
 * 
 */
package core.member;

import java.util.ArrayList;

/**
 * @author ro6k4
 *
 */
public interface IMemberCollection {

	/**
	 * 
	 * @param member the member to exclude from the list of participants
	 * @return the list of participants except an excluded one
	 */
	public ArrayList<IMember> getOtherMembers(IMember member);
	
	public ArrayList<IMember> getSortAscByScore();
	
	public ArrayList<IMember> getSortDescByScore();
	
	public IMember getMinMemberByScore();
	
	public IMember getMaxMemberByScore();
	
}
