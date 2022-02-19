/**
 * 
 */
package core.association;

import core.member.IMember;

/**
 * @author ro6k4
 *
 */
public class Association implements IAssociation {
	
	private IMember gifter;
	private IMember receiver;
	
	public Association(IMember gifter, IMember receiver) {
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
