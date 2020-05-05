package leetCode30Day;

public class StringShift14 {

	public static void main(String[] args) {
		String s = "abc";
		int[][] shift = {{0,1},{1,2}};

		String ansStr = run(s,shift);
		
		System.out.println(ansStr);


	}

	private static String run(String s, int[][] shift) {
		int actionNum = getActionNum(shift);
		int length = s.length();
		String ansStr;
		int tempInt = actionNum % length;
		if(tempInt < 0) {
            tempInt = -1 * tempInt;
			ansStr = s.substring(tempInt) + s.substring(0, tempInt);
		}else if(tempInt > 0){
            tempInt = length-tempInt;
			ansStr = s.substring(tempInt) + s.substring(0, tempInt);
		}else {
			ansStr = s;
		}

		return ansStr;
	}


	private static int getActionNum(int[][] shift) {
		int actionNum = 0;
		
		for(int[] shiftEle : shift) {
			switch(shiftEle[0]) {
			case 0:
				actionNum = actionNum - shiftEle[1];
				break;
			case 1:
				actionNum = actionNum + shiftEle[1];
				break;
			}
		}
		
		return actionNum;
	}

}
