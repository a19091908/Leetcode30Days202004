package leetCode30Day;

public class NumberOfIslands17 {

	public static void main(String[] args) {
		char [][] intArr = {
				{'1','1','1','1','0'},
				{'1','1','0','1','0'},
				{'1','1','0','0','0'},
				{'0','0','0','0','1'}
				};
		
		int ans = run(intArr);
		System.out.println(ans);
	}

	private static int run(char[][] grid) {
        if(grid.length == 0)
            return 0;
		int counts = 0;
		int n = grid.length;
		int m = grid[0].length;
		
		for(int i = 0 ; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(grid[i][j] == '0')
					continue;
				findIsland(grid, i, j);
				counts++;		
			}
		}

		return counts;
	}

	private static void findIsland(char[][] grid, int i, int j) {
		if( i < 0 || j < 0 ||
		    i  >= grid.length || 
		    j >= grid[0].length ||
		    grid[i][j] == '0')
			return;
		grid[i][j] = '0';
		findIsland(grid, i+1,j);
		findIsland(grid, i-1,j);
		findIsland(grid, i,j+1);
		findIsland(grid, i,j-1);
		
	}

}
