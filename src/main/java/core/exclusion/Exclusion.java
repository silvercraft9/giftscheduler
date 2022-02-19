/**
 * 
 */
package core.exclusion;

import core.member.IMember;

/**
 * @author ro6k4
 *
 */
public class Exclusion implements IExclusion {
	
	private IMember gifter;
	private IMember receiver;
	
	public Exclusion(IMember gifter, IMember receiver) {
		this.gifter = gifter;
		this.receiver = receiver;
	}

	public IMember getGifter() {
		return this.gifter;
	}

	public IMember getReceiver() {
		return this.receiver;
	}

}
