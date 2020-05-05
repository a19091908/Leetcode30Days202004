package leetCode30Day;

public class BinaryTreeMaximumPathSum29 {
	static int max;
	public static void main(String[] args) {
		TN tempTN = null;
		TN root = new TN(-10);
		root.left = new TN(9);
		tempTN = new TN(20);
		root.right = tempTN;
		tempTN.left = new TN(15);
		tempTN.right = new TN(7);
		
		int ans = run(root);
		System.out.println(ans);
	}

	private static int run(TN root) {
		max = Integer.MIN_VALUE;
		
		findMax(root);

		return max;
	}

	private static int findMax(TN node) {
		if (node == null) {
			return 0;
		}
		
		int leftVal = findMax(node.left);
		int rightVal = findMax(node.right);
		int nodeMaxVal = node.val;
		if(leftVal > 0) {
			nodeMaxVal += leftVal;
		}
		if (rightVal > 0) {
			nodeMaxVal = Math.max(nodeMaxVal, node.val + rightVal);
		}
		
		
		max = Math.max(max, leftVal + rightVal + node.val);
		max = Math.max(max, nodeMaxVal);
		return nodeMaxVal;
	}

}

class TN {
    int val;
    TN left;
    TN right;
    TN() {}
    TN(int val) { this.val = val; }
    TN(int val, TN left, TN right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
