/**
 * 
 */
package core.member;

/**
 * @author ro6k4
 *
 */
public interface IMember {

	/**
	 * 
	 * @return the name of the of the member
	 */
	public String getName();
	
	/**
	 * 
	 * @param name the new name to associate to the member
	 */
	public void setName(String name);
	
	/**
	 * 
	 * @return the address of the member (email or any contact)
	 */
	public String getAddress();
	
	/**
	 * 
	 * @param name the new address to associate to the member
	 */
	public void setAddress(String address);
	
	/**
	 * 
	 * @return the score associated to the member
	 */
	public Integer getScore();
	
	/**
	 * 
	 * @param score the new score to associate to the member
	 */
	public void setScore(Integer score);
	
}
