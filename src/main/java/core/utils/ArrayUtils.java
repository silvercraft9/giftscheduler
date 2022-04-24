/**
 * 
 */
package core.utils;

import java.util.ArrayList;

import core.member.IMember;

/**
 * @author ro6k4
 *
 */
public class ArrayUtils {
	
	public static Integer minValue(ArrayList<Integer> values) {
		int min = Integer.MAX_VALUE;
		int nbValues = values.size();
		for(int i = 0; i < nbValues; i++) {
			int value = values.get(i);
			if(value < min) {
				min = value;
			}
		}
		return min;
	}
	
	public static Integer minIndex(ArrayList<Integer> values) {
		int min = Integer.MAX_VALUE;
		int minIndex = 0;
		int nbValues = values.size();
		for(int i = 0; i < nbValues; i++) {
			int value = values.get(i);
			if(value < min) {
				min = value;
				minIndex = i;
			}
		}
		return minIndex;
	}
	
	public static Integer maxValue(ArrayList<Integer> values) {
		int max = Integer.MIN_VALUE;
		int nbValues = values.size();
		for(int i = 0; i < nbValues; i++) {
			int value = values.get(i);
			if(value < max) {
				max = value;
			}
		}
		return max;
	}
	
	public static Integer maxIndex(ArrayList<Integer> values) {
		int max = Integer.MAX_VALUE;
		int maxIndex = 0;
		int nbValues = values.size();
		for(int i = 0; i < nbValues; i++) {
			int value = values.get(i);
			if(value < max) {
				max = value;
				maxIndex = i;
			}
		}
		return maxIndex;
	}
	
	public static ArrayList<IMember> duplicateList(ArrayList<IMember> list){
		ArrayList<IMember> res = new ArrayList<IMember>();
		int size = list.size();
		for(int i = 0; i < size; i++) {
			res.add(list.get(i));
		}
		return res;
	}
	
	public static String memberArrayToString(ArrayList<IMember> members) {
		String res = "[Members: ";
		int nbMembers = members.size();
		for(int i = 0; i < nbMembers; i++) {
			IMember curr = members.get(i);
			res += "{" + curr.getName() + "_" + curr.getAddress() + "}";
		}
		res += " ]";
		return res;
	}

}
