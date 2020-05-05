package leetCode30Day;

public class BstFromPreorder20 {

	public static void main(String[] args) {
		int[] preorder = {8,5,1,7,10,12};
		TreeNode1 treeNode = run(preorder);

	}

	private static TreeNode1 run(int[] preorder) {
		if(preorder.length == 0) return null;
		
		TreeNode1 rootTreeNode = new TreeNode1(preorder[0]);
		TreeNode1 tempRootTreeNode;
		
		for(int i = 1 ; i < preorder.length ; i++) {
			tempRootTreeNode = rootTreeNode;
			while(true) {
				if(tempRootTreeNode.val > preorder[i]) {
					if(tempRootTreeNode.left == null) {
						tempRootTreeNode.left = new TreeNode1(preorder[i]);
						break;
					}else {
						tempRootTreeNode = tempRootTreeNode.left;
					}
				}else {
					if(tempRootTreeNode.right == null) {
						tempRootTreeNode.right = new TreeNode1(preorder[i]);
						break;
					}else {
						tempRootTreeNode = tempRootTreeNode.right;
					}
				}
			}			
		}
		
		return rootTreeNode;
	}

}

 /**
  * Definition for a binary tree node.
  * @author syuan-ying-wu
  *
  */
  class TreeNode1{
     int val;
     TreeNode1 left;
     TreeNode1 right;
     TreeNode1(int x) { val = x; }
 }

