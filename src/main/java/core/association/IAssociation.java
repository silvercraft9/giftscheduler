package core.association;

import core.member.IMember;

public interface IAssociation {
	
	/**
	 * 
	 * @return the member offering a gift
	 */
	public IMember getGifter();
	
	/**
	 * 
	 * @return the member receiving a gift
	 */
	public IMember getReceiver();
	
}
