package leetCode30Day;


public class IsValidSequence30 {

	public static void main(String[] args) {
		int[] arr = {0,1,0,1};
		TreeNode5 root = new TreeNode5(0);
		root.left = new TreeNode5(1);
		root.right = new TreeNode5(0);
		TreeNode5 temp = root.left;
		temp.left = new TreeNode5(0);
		temp.right = new TreeNode5(1);
		temp.left.right = new TreeNode5(1);
		temp.right.left = new TreeNode5(0);
		temp.right.right = new TreeNode5(0);
		root.right.left = new TreeNode5(0);
		
		boolean ans = isValidSequence(root, arr);
		System.out.println(ans);
	}
	
	public static boolean isValidSequence(TreeNode5 root, int[] arr) {
		return findNext(root, 0, arr);
    }

	private static boolean findNext(TreeNode5 node, int i, int[] arr) {
			
		if (node == null) {
			return false;
		}

		if (node.val != arr[i])
			return false;
		
		if (i == arr.length-1) {
			if (node.right == null && node.left == null) {
				return true;
			}else {
				return false;
			}
		}else {
			return findNext(node.left, i+1, arr) || findNext(node.right, i+1, arr);
		}
	}

}
class TreeNode5 {
    int val;
    TreeNode5 left;
    TreeNode5 right;
    TreeNode5() {}
    TreeNode5(int val) { this.val = val; }
    TreeNode5(int val, TreeNode5 left, TreeNode5 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
