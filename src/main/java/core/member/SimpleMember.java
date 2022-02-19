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
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public boolean equals(Object o) {
		IMember member = (IMember) o;
		return (this.name.equalsIgnoreCase(member.getName()) && this.address.equalsIgnoreCase(member.getAddress()));
	}
}
