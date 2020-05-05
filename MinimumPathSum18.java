package leetCode30Day;

public class MinimumPathSum18 {

	public static void main(String[] args) {
		int[][] matrix = {
				{0,1},
				{1,0}
		};
		
		int ans = run(matrix);
		System.out.println(ans);
	}

	private static int run(int[][] grid) {
		int[][] memoryTable = new int[grid.length][grid[0].length];
		if(grid.length == 1 && grid[0].length == 1)
            return grid[0][0];
		return findRoad(grid,0,0,memoryTable);
	}

	private static int findRoad(int[][] grid, int i, int j, int[][] memoryTable) {
		int rowTemp = Integer.MAX_VALUE, colTemp = Integer.MAX_VALUE;
		int iMax = grid.length;
		int jMax = grid[0].length;
		
		if(i == iMax-1 && j == jMax-1) 
			return grid[i][j];
		else if(memoryTable[i][j] != 0)
			return memoryTable[i][j];
		else {
			if(i < iMax-1 )
				rowTemp = findRoad(grid,i+1,j,memoryTable);
			if(j < jMax-1 )
				colTemp = findRoad(grid,i,j+1,memoryTable);
			memoryTable[i][j] = Math.min(rowTemp, colTemp) + grid[i][j];
			return memoryTable[i][j];
		}	
	}

}
