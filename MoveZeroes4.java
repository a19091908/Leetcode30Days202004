package leetCode30Day;

public class MoveZeroes4 {

	public static void main(String[] args) {
		int[] nums = {0,1,0,3,12};
		run(nums);
		for(int ele:nums)
			System.out.print(ele + " ");
	}

	private static void run(int[] nums) {
		int theNumnerOfZero = 0;
		int index = 0 ;
		int length = nums.length;
		for(int i = 0 ; i < length ; i++) {
			if(nums[i] == 0) {
				theNumnerOfZero++;
			}else {
				nums[index] = nums[i];
				index++;
			}
		}
		length = nums.length;
		for(int i=1; i<=theNumnerOfZero; i++)
			nums[length-i] = 0;
		
	}

}
