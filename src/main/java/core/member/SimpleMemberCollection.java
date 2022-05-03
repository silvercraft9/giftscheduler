/**
 * 
 */
package core.member;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author ro6k4
 *
 */
public class SimpleMemberCollection implements IMemberCollection {

	private ArrayList<IMember> collection;
	
	public SimpleMemberCollection() {
		this.collection = new ArrayList<IMember>();
	}

	public SimpleMemberCollection(ArrayList<IMember> collection) {
		this.collection = collection;
	}
	
	public boolean contains(IMember member) {
		return this.collection.contains(member);
	}
	
	public void addMember(IMember member) {
		if(!this.contains(member)) {
			this.collection.add(member);
		}
	}

	public void deleteMember(IMember member) {
		ArrayList<IMember> updated = this.collection;
		int size = updated.size();
		for(int i = 0; i < size; i++) {
			IMember current = this.collection.get(i);
			if(member.equals(current)) {
				updated.remove(i);
				size--;
			}	
		}
		this.collection = updated;
	}
	
	public ArrayList<IMember> getMembers() {
		return this.collection;
	}
	
	public void setMembers(ArrayList<IMember> members) {
		this.collection = members;
	}
	
	public ArrayList<IMember> getOtherMembers(IMember member) {
		ArrayList<IMember> others = new ArrayList<IMember>();
		int size = this.collection.size();
		for(int i = 0; i < size; i++) {
			IMember current = this.collection.get(i);
			if(!member.equals(current)) {
				others.add(current);
			}
		}
		return others;
	}

	public ArrayList<IMember> getSortAscByScore() {
		ArrayList<IMember> sorted = this.collection;
		Collections.sort(sorted);
		return sorted;
	}

	public ArrayList<IMember> getSortDescByScore() {
		ArrayList<IMember> sortedAsc = this.getSortAscByScore();
		ArrayList<IMember> sortedDesc = new ArrayList<IMember>();
		int size = sortedAsc.size();
		for(int i = size - 1; i >= 0; i--) {
			IMember member = sortedAsc.get(i);
			sortedDesc.add(member);
		}
		return sortedDesc;
	}

	public IMember getMinMemberByScore() {
		IMember minMember = this.collection.get(0);
		int size = this.collection.size();
		for(int i = 1; i < size; i++) {
			IMember current = this.collection.get(i);
			int currScore = current.getScore();
			int minScore = minMember.getScore();
			if(currScore < minScore) {
				minMember = current;
			}
		}
		return minMember;
	}

	public IMember getMaxMemberByScore() {
		IMember maxMember = this.collection.get(0);
		int size = this.collection.size();
		for(int i = 1; i < size; i++) {
			IMember current = this.collection.get(i);
			int currScore = current.getScore();
			int maxScore = maxMember.getScore();
			if(currScore > maxScore) {
				maxMember = current;
			}
		}
		return maxMember;
	}

	

	

}
