/**
 * 
 */
package config;

import java.util.ArrayList;

import core.exclusion.IExclusionSet;
import core.member.IMember;

/**
 * @author ro6k4
 *
 */
public interface IConfigParser {
	
	/**
	 * This method loads parameters from configuration files
	 */
	public void initialize();
	
	/**
	 * This method returns the list of members to consider
	 * @return the list of members to consider
	 */
	public ArrayList<IMember> getMembers();
	
	/**
	 * This method returns the set of exclusions to consider 
	 * @return the set of exclusions to consider
	 */
	public IExclusionSet getExclusions();
	
	/**
	 * This method returns the name of the project if it is configured, otherwise a default name "project n" where n is a unique number
	 * @return the name of the project
	 */
	public String getProjectName();

}
