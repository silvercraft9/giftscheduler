/**
 * 
 */
package core.exclusion;


/**
 * @author ro6k4
 *
 */
public interface IExclusion {

	/**
	 * This method returns the name of the member who can not offer the gift
	 * @return the name of the giver
	 */
	public String getGiverName();
	
	/**
	 * This method returns the name of the member who can not receive the gift
	 * @return the name of the receiver
	 */
	public String getRcvName();
}
