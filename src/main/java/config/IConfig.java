/**
 * 
 */
package config;

import java.util.ArrayList;

import core.exclusion.IExclusion;
import core.member.IMember;

/**
 * @author admin
 * This interface defines basic methods for each Config loader
 */
public interface IConfig {

	/**
	 * 
	 * @return the source describing the configuration
	 */
	public String getSource();
	
	/**
	 * 
	 * @return true if the configuration is loaded successfully, false otherwise
	 */
	public boolean init();
	
	/**
	 * 
	 * @return the list of members 
	 */
	public ArrayList<IMember> getMembers();
	
	/**
	 * 
	 * @return the list exclusions
	 */
	public ArrayList<IExclusion> getExclusions();
}
