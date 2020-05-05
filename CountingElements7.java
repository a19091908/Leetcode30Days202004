package leetCode30Day;

import java.util.HashMap;
import java.util.Map;

public class CountingElements7 {

	public static void main(String[] args) {
		int[] inputArr = {1,3,2,3,5,0};
		int ans = run(inputArr);
		System.out.println(ans);
	}

	private static int run(int[] arr) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>(); 
		for(int ele:arr) {
			if(map.containsKey(ele)) {
				map.replace(ele, map.get(ele)+1);
			}else {
				map.put(ele, 1);
			}
		}
		int ans = 0;
		int mapSize = map.size();
		Integer tempInt;
		Object[] intArr =  map.keySet().toArray();
		for(int i = 0; i < mapSize ; i++) {
			tempInt = (int)intArr[i];
			if(map.get(tempInt+1) != null)
				ans += map.get(tempInt);
		}
		
		return ans;
	}

}
