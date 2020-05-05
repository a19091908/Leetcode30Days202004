package leetCode30Day;

public class SearchInRotatedSortedArray19 {

	public static void main(String[] args) {
		int[] nums = {3,1};
		int target = 1;
		int ans = run(nums, target);
		System.out.println(ans);
	}

	private static int run(int[] nums, int target) {
		int startIndex = 0, endIndex = nums.length-1;
		int midIndex;
		
		while(startIndex < endIndex) {
			midIndex = (startIndex + endIndex) / 2;
			if(nums[midIndex] == target) return midIndex;
			
			if(nums[startIndex] < nums[midIndex]) {
				if(nums[startIndex] <= target && target < nums[midIndex]) {
					endIndex = midIndex-1;
				}else {
					startIndex = midIndex+1;
				}
			}else {
				if(nums[midIndex] < target && target <= nums[endIndex]) {
					startIndex = midIndex+1;
				}else {
					endIndex = midIndex-1;
				}
			}
			
		}
		
		return nums[startIndex]==target?startIndex:-1;
	}

}
