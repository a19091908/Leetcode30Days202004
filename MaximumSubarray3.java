package leetCode30Day;

public class MaximumSubarray3 {

	public static void main(String[] args) {
		int[] nums = {-2,-1};
		
		int ansSum = run(nums);
		System.out.println(ansSum);

	}

	private static int run(int[] nums) {
		int minSumFromFirst = nums[0];
		int maxSum = nums[0];
		int currentSumFromFirst = nums[0];
		for(int i = 1; i < nums.length; i++) {
			currentSumFromFirst += nums[i];
			if(minSumFromFirst < 0)
				maxSum = Math.max(maxSum, currentSumFromFirst - minSumFromFirst);
			else
				maxSum = Math.max(maxSum, currentSumFromFirst);
			minSumFromFirst = Math.min(minSumFromFirst, currentSumFromFirst);
		}

		return maxSum;
	}

}
