package leetCode30Day;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK21 {

	public static void main(String[] args) {
		int[] nums = {0,0,0,0,0,0,0,0,0,0};
		int k = 0;
		int ans = run(nums,k);
		System.out.println(ans);

	}

	private static int run(int[] nums, int k) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		Integer temp ;
		int ans = 0, currentSum = 0;
		
		for(int i = 0 ; i < nums.length ; i++) {
			currentSum += nums[i];
			if(currentSum == k) {
				temp = map.get(currentSum-k);
				if ( temp != null) {
					ans = ans + temp;
				}
				ans++;
				
				extracted(map, currentSum);
				
				
				
				continue;
			}else {
				temp = map.get(currentSum-k);
				if ( temp != null) {
					ans = ans + temp;
					
					extracted(map, currentSum);
					
					continue;
				}else {
					extracted(map, currentSum);
				}
			}
		}
		return ans;
	}

	private static void extracted(Map<Integer, Integer> map, int currentSum) {
		Integer temp;
		temp = map.get(currentSum);
		if(temp == null)
			map.put(currentSum, 1);
		else
			map.put(currentSum, temp+1);
	}

}
