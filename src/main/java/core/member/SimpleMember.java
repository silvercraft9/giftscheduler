/**
 * 
 */
package core.member;

/**
 * @author ro6k4
 *
 */
public class SimpleMember implements IMember {

	private String name;
	private String address;
	
	public SimpleMember(String name, String address) {
		this.name = name;
		this.address = address;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
}
