/**
 * 
 */
package core.exclusion;

import core.ISet;

/**
 * @author ro6k4
 *
 */
public interface IExclusionSet extends ISet {
	
	/**
	 * This method puts an exclusion in the set if it does not exist already, nothing otherwise
	 * @param e The exclusion to put in the set
	 * @return 1 if the IExclusion is inserted properly, 0 otherwise
	 */
	public int put(IExclusion e);
	
	/**
	 * This method deletes an exclusion from the set if it does exist, nothing otherwise 
	 * @param e The exclusion to delete from the set
	 * @return 1 if the IExclusion is deleted, 0 otherwise
	 */
	public int delete(IExclusion e);

}
