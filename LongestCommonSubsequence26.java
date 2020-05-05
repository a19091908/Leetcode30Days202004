package leetCode30Day;

public class LongestCommonSubsequence26 {

	public static void main(String[] args) {
		String text1 = "abcde", text2 = "ace";		
		int ans = run(text1, text2);
		System.out.println(ans);
	}

	private static int run(String text1, String text2) {
		int[][] arr = new int[text1.length()+1][text2.length()+1];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i][0] = 0;
		}
		
		for (int i = 0; i < arr[0].length; i++) {
			arr[0][i] = 0;
		}
		
		for(int i = 1; i < arr.length ; i++) {
			for(int j = 1; j < arr[0].length ; j++) {
				if(text1.charAt(i-1) == text2.charAt(j-1)) {
					arr[i][j] = arr[i-1][j-1] + 1;
					continue;
				}else {
					if(arr[i-1][j] >= arr[i][j-1]) {
						arr[i][j] = arr[i-1][j];
						continue;
					}else {
						arr[i][j] = arr[i][j-1];
						continue;
					}			
				}
			}
		}

		
		return arr[text1.length()][text2.length()];
	}

}
