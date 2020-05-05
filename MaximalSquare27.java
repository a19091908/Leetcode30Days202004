package leetCode30Day;

public class MaximalSquare27 {

	public static void main(String[] args) {
		char[][] matrix = {
				{'1','0','1','0','0'},
				{'1','0','1','1','1'},
				{'1','1','1','1','1'},
				{'1','0','0','1','0'}
				};
		
		int ansArea = run(matrix);
		System.out.println(ansArea);

	}

	private static int run(char[][] matrix) {
		if(matrix.length == 0) return 0;
		
		int maxSide = 0;
		int[][] dp = new int[matrix.length][matrix[0].length];
		
		for (int i = 0; i < dp.length; i++) {
			if(matrix[i][0] == '1') {
				maxSide = 1;
				dp[i][0] = 1;
			}
		}
		
		for (int i = 0; i < dp[0].length; i++) {
			if(matrix[0][i] == '1') {
				maxSide = 1;
				dp[0][i] = 1;
			}
		}
		
		int tempMin;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if(matrix[i][j] == '1') {
					tempMin = Math.min(dp[i-1][j], dp[i][j-1]);
					tempMin = Math.min(tempMin, dp[i-1][j-1]);
					dp[i][j] = tempMin+1;
					maxSide = Math.max(maxSide, tempMin+1);
				}	
			}
		}
		
		
		return maxSide*maxSide;
	}

}
