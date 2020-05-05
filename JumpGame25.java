package leetCode30Day;

public class JumpGame25 {
	public static void main(String[] args) {
		int[] nums = {2,2,1,1,4};
		boolean ans = run(nums);
		System.out.println(ans);
	}

	private static boolean run(int[] nums) {
		int lastIndex = nums.length-1;
		for (int i = nums.length-1-1; i >= 0 ; i--) {
			if(i+nums[i] >= lastIndex) {
				lastIndex = i;
			}
		}
		
		return lastIndex == 0;
	}

}
