package leetCode30Day;

public class BitwiseAndOfNumbersRange23 {

	public static void main(String[] args) {
		int[] intArr = {5,7};
		int ans = run(intArr[0], intArr[1]);
		System.out.println(ans);
	}

	private static int run(int m, int n) {
		int ans = 0;
		char[] charM = Integer.toBinaryString(m).toCharArray();
		char[] charN = Integer.toBinaryString(n).toCharArray();
		
		if(charM.length != charN.length)
			return 0;
		else {
			for (int i = 0; i < charN.length; i++) {
				if(charM[i] == charN[i]) {
					if(charM[i] == '1')
						ans =  ans + (int)Math.pow(2, charN.length-1-i);
				}else break;
			}
		}
		return ans;
	}

}
