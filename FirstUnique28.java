package leetCode30Day;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class FirstUnique28 {
	Queue<Integer> firstUnique;
	Set<Integer> set;
	Set<Integer> uniqueMap;
	
	public static void main(String[] args) {
		int[] nums = {2,3,5};
		FirstUnique28 fu = new FirstUnique28(nums);
		int unique = fu.showFirstUnique();
		System.out.println(unique);
		fu.add(2);
		unique = fu.showFirstUnique();
		System.out.println(unique);

	}
	
	public FirstUnique28(int[] nums) {
		firstUnique = new LinkedList<Integer>();
		set = new HashSet<Integer>();
		uniqueMap = new HashSet<Integer>();
		
		for (int ele:nums) {
			add(ele);
		}
	}

	public int showFirstUnique() {
		return firstUnique.isEmpty() ? -1 : firstUnique.peek();
	}

	public void add(int value) {
		if (set.contains(value)) {
			if(uniqueMap.contains(value)) {
				firstUnique.remove(value);
				uniqueMap.remove(value);
			}
		}else {
			set.add(value);
			firstUnique.add(value);
			uniqueMap.add(value);
		}
	}

}
