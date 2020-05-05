package leetCode30Day;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray13 {

	public static void main(String[] args) {
		int[] intArr = {0,1,0,1,1,1,0,0,1,1,0,1,1,1,1,1,1,0,1,1,0,1,1,0,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,0,0,0,0,1,0,0,0,1,1,1,0,1,0,0,1,1,1,1,1,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,0,0,0,1,0,1,0,1,1,0,0,1,1,0,1,1,1,1,0,1,1,0,0,0,1,1};
//		int ans = run(intArr);
		int ans = 1;

		System.out.println(ans);

	}

	private static int run(int[] nums) {
		int length = nums.length;
		int numberOfAllOne = 0;
		int tempLength, maxJ;
		Calculator tempCalculator;
		Calculator[] calculatorArr = new Calculator[length];
		for(int num: nums)
			numberOfAllOne = numberOfAllOne + num;
		tempCalculator = new Calculator(length - numberOfAllOne, numberOfAllOne);
		if(isTheNumberOfTwoNumberEqual(tempCalculator))
			return length;
		calculatorArr[0] = tempCalculator;
		
		for(int i = 1; i < length; i++) {
			tempLength = length - i;
			maxJ = i + 1;
			for(int j = maxJ - 1; j >=0 ; j--) {
				if(i == j) {
					tempCalculator = 
							getTempCalculator(nums[i-1], calculatorArr[j-1]);
				}else {
					tempCalculator = 
							getTempCalculator(nums[tempLength + j], calculatorArr[j]);
				}
				
				if(isTheNumberOfTwoNumberEqual(tempCalculator)) {
					return tempLength;
				}
				calculatorArr[j] = tempCalculator;			
			}
		}

		return 0;
	}

	private static boolean isTheNumberOfTwoNumberEqual(Calculator tempCalculator) {
		return tempCalculator.numberOfZero == tempCalculator.numberOfOne;
	}

	private static Calculator getTempCalculator(int deletedNum, Calculator tempCalculator) {
		if(deletedNum == 0) {
			return new Calculator(tempCalculator.numberOfZero - 1,
							tempCalculator.numberOfOne);
		}else {
			return new Calculator(tempCalculator.numberOfZero, 
							tempCalculator.numberOfOne - 1);
		}
	}

}
class Calculator{
	int numberOfZero;
	int numberOfOne;
	Calculator(int numberOfZero, int numberOfOne){
		this.numberOfZero = numberOfZero;
		this.numberOfOne = numberOfOne;
	}
}
