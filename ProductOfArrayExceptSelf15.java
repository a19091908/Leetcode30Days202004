package leetCode30Day;

public class ProductOfArrayExceptSelf15 {

	public static void main(String[] args) {
		int [] intArr = {1,2,3,4};
		
		int[] ansArr = run(intArr);

		for(int num:ansArr)
			System.out.println(num);
	}

	private static int[] run(int[] nums) {
		int tempLeftValue = 1, tempRightValue = 1;
		int length = nums.length;
		int[] ansArr = new int[length];
		
		for(int i = 0 ; i < length; i++) {
			ansArr[i] = 1;
		}
		for(int i = 1 ; i < length; i++) {
			tempLeftValue = tempLeftValue * nums[i-1];
			ansArr[i] = tempLeftValue * ansArr[i];
			
			tempRightValue = tempRightValue * nums[length-i];
			ansArr[length-i-1] = tempRightValue * ansArr[length-i-1];
			
		}
			
		return ansArr;
	}

}
