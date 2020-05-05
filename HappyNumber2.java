package leetCode30Day;

public class HappyNumber2 {

	public static void main(String[] args) {
		int inputInt = 2;
		boolean ans = run(inputInt);
		System.out.println(ans);
	}

	private static boolean run(int n) {
		int remainder = 0;
        int tempNum = n;
        int squareSum = n;
        int processCounts = 0;
        
        while(processCounts < 100 && squareSum != 1){
        	processCounts++;
            tempNum = squareSum;
            squareSum = 0;
            while(tempNum >= 10){
                remainder = tempNum % 10;
                tempNum = tempNum / 10;
                squareSum += remainder * remainder;
            }
            squareSum += tempNum * tempNum;    
        }
        if(squareSum == 1)
        	return true;
        else
        	return false;
	}

}
