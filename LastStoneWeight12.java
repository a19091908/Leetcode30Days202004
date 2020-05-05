package leetCode30Day;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight12 {

	public static void main(String[] args) {
		int[] intArr = {2,7,4,1,8,1};
		int ans = run(intArr);
		System.out.println(ans);
	}

	private static int run(int[] intArr) {
		if(intArr.length == 0) {
			return 0;
		}
		
		Comparator<Integer> comparaotor = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		};
		PriorityQueue<Integer> pq = 
				new PriorityQueue<Integer>(intArr.length, comparaotor);
		for(int i: intArr) {
			pq.offer(i);
		}
		
		while(pq.size() > 1) {
			Integer firstLargeVal = pq.poll();
			Integer secondLargeVal = pq.poll();
			
			pq.offer(firstLargeVal - secondLargeVal);
		}
		
		
		return pq.poll();
	}

}
