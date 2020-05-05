package leetCode30Day;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber1 {

	public static void main(String[] args) {
		int[] arr = {4,1,2,1,2};
		
		int tempInt = -1;
		Set<Integer> set = new HashSet<>();
		
		for(int i = 0; i<arr.length; i++) {
			tempInt = arr[i];
			if(set.contains(tempInt)) {
				set.remove(tempInt);
				continue;
			}else {
				set.add(tempInt);
			}
		}
		
		for(int ans: set) {
			tempInt = ans;
		}
		
		System.out.println(tempInt);
	}

}
