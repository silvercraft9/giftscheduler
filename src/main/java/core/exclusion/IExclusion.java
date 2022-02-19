package core.exclusion;

import core.member.IMember;

public interface IExclusion {

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
