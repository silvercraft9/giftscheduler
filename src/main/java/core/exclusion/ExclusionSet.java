/**
 * 
 */
package core.exclusion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import core.member.IMember;

/**
 * @author ro6k4
 *
 */
public class ExclusionSet implements IExclusionSet {
	
	private HashMap<IMember, ArrayList<IMember>> forbidden;

	public ExclusionSet(ArrayList<IExclusion> exclusions) {
		this.forbidden = new HashMap<IMember, ArrayList<IMember>>();
		int n = exclusions.size();
		for(int i = 0; i < n; i++) {
			IExclusion excl = exclusions.get(i);
			IMember gifter = excl.getGifter();
			IMember receiver = excl.getReceiver();
			
			ArrayList<IMember> exclReceivers = this.forbidden.get(gifter);
			if(exclReceivers != null) {
				if(!exclReceivers.contains(receiver)) {
					exclReceivers.add(receiver);
				}		
			} else {
				exclReceivers = new ArrayList<IMember>();
				exclReceivers.add(receiver);
			}
			this.forbidden.put(gifter, exclReceivers);
		}
	}


	public int getNbExcludedReceivers(IMember gifter) {
		return this.forbidden.get(gifter).size();
	}

	public int getNbExcludedGifters(IMember receiver) {
		int res = 0;
		Set<IMember> gifters = this.forbidden.keySet();
		Iterator<IMember> iterator = gifters.iterator();
		while(iterator.hasNext()) {
			ArrayList<IMember> exclReceivers = this.forbidden.get(iterator.next());
			if(exclReceivers.contains(receiver)) {
				res++;
			}
		}
		return res;
	}

	public ArrayList<IMember> getExcludedReceivers(IMember gifter) {
		return this.forbidden.get(gifter);
	}

	public ArrayList<IMember> getExcludedGifters(IMember receiver) {
		ArrayList<IMember> res = new ArrayList<IMember>();
		Set<IMember> gifters = this.forbidden.keySet();
		Iterator<IMember> iterator = gifters.iterator();
		while(iterator.hasNext()) {
			IMember gifter = iterator.next();
			ArrayList<IMember> exclReceivers = this.forbidden.get(gifter);
			if(exclReceivers.contains(receiver) && !res.contains(gifter)) {
				res.add(gifter);
			}
		}
		return res;
	}


	public void addExclusion(IExclusion exclusion) {
		IMember gifter = exclusion.getGifter();
		IMember receiver = exclusion.getReceiver();
		ArrayList<IMember> receivers = this.forbidden.get(gifter);
		if(!receivers.contains(receiver)) {
			receivers.add(receiver);
		}
		this.forbidden.put(gifter, receivers);
	}

}
