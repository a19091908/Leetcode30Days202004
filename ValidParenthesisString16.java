package leetCode30Day;

public class ValidParenthesisString16 {

	public static void main(String[] args) {
		String str = "(())(())(((()*()()()))()((()()(*()())))(((*)()";
		boolean ans = run(str);
		System.out.println(ans);
	}

	private static boolean run(String s) {
		int lowerBound = 0 , uppperBound = 0 ;
		char[] charArr = s.toCharArray();
		char tempChar;
		int length = charArr.length;
		for(int i = 0 ; i < length ; i++) {
			tempChar = charArr[i];
			switch(tempChar) {
			case '(':
				lowerBound++;
				uppperBound++;
				break;
			case ')':
				lowerBound--;
				uppperBound--;
				break;
			case '*':
				lowerBound--;
				uppperBound++;
				break;
			}
			if(uppperBound < 0)
				return false;
			lowerBound = Math.max(0, lowerBound);
		}
		
		return lowerBound ==0;
	}

}
