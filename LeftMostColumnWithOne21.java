package leetCode30Day;

import java.util.LinkedList;
import java.util.List;

public class LeftMostColumnWithOne21 {

	public static void main(String[] args) throws Exception {
		int[][] intArr = {
				{0,0},
				{1,1}
				};
		BinaryMatrix bm = new BinaryMatrix(intArr);
		int ans = run(bm);
		System.out.println(ans);

	}

	private static int run(BinaryMatrix binaryMatrix) throws Exception {
		List<Integer> list = binaryMatrix.dimensions();
		int row = list.get(0), col = list.get(1);
		int lowestIndex = -1;
		int left = 0, right = col, mid = (right + left) / 2;
		for (int i = 0; i < row; i++) {
			left = 0;
			right = (lowestIndex == -1)? col-1 : lowestIndex;
			while(left <= right) {
				mid = (right + left) / 2;
				if(binaryMatrix.get(i, mid) == 1) {
					lowestIndex = mid;
					right = mid-1;
				}else {
					left = mid+1;
				}	
			}
		}
		return lowestIndex;
	}

}

class BinaryMatrix {
	private int[][] matrix;
	private List<Integer> list;
	int i = 0;
	
	BinaryMatrix(int[][] intArr){
		matrix = intArr;
		
		list = new LinkedList<Integer>();
		list.add(intArr.length);
		list.add(intArr[0].length);
	}

	public int get(int x, int y) throws Exception {
		i++;
		if (i >1000) {
			throw new Exception("too much call");
		}
		return matrix[x][y];
	};

	public List<Integer> dimensions() {
		return list;
	};
};
