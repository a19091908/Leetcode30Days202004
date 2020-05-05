package leetCode30Day;

public class DiameterOfBinaryTree11 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode tempNode;
		tempNode = root.add(TreeNode.LEFTNode, 2);
		root.add(TreeNode.RIGHTNode, 3);
		tempNode.add(TreeNode.LEFTNode, 4);
		tempNode.add(TreeNode.RIGHTNode, 5);
		
		int ans = findDiameter(root);
		System.out.println(ans);

	}

	private static int findDiameter(TreeNode root) {
		NodeInfo nodeInfo = findHeightOfTree(root);
		return nodeInfo.maxDiameter - 1;
	}

	private static NodeInfo findHeightOfTree(TreeNode root) {
		int leftHeight, rightHeight, nodeMax;
		NodeInfo nodeInfo;
		int leftMaxDiameter = 0 , rightMaxDiameter = 0;
		if(root == null) {
			return new NodeInfo();
		}
		if(root.left != null) {
			nodeInfo = findHeightOfTree(root.left);
			leftHeight = nodeInfo.nodeHeight;
			leftMaxDiameter = nodeInfo.maxDiameter;
		}else {
			leftHeight = 0;
		}
		if(root.right != null) {
			nodeInfo = findHeightOfTree(root.right);
			rightHeight = nodeInfo.nodeHeight;
			rightMaxDiameter = nodeInfo.maxDiameter;
		}else {
			rightHeight = 0;
		}
		nodeInfo = new NodeInfo();
		if (leftHeight >= rightHeight) {
			nodeInfo.nodeHeight = leftHeight + 1;
		} else {
			nodeInfo.nodeHeight = rightHeight + 1;
		}
		
		nodeMax = leftHeight + rightHeight + 1;
		nodeMax = Math.max(nodeMax, leftMaxDiameter);
		nodeMax = Math.max(nodeMax, rightMaxDiameter);

		nodeInfo.maxDiameter = nodeMax;
		return nodeInfo;
	}

}

/**
 * Definition for a binary tree node.
 * @author syuan-ying-wu
 *
 */
class TreeNode {
	static final int LEFTNode = 1;
	static final int RIGHTNode = 2;
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
	
	TreeNode add(int leftOrRight, int value) {
		TreeNode newNode = new TreeNode(value);
		switch(leftOrRight) {
		case(TreeNode.LEFTNode):
			this.left = newNode;
			break;
		case(TreeNode.RIGHTNode):
			this.right = newNode;
			break;
		}
		return newNode;
	}

}

class NodeInfo{
	int nodeHeight = 1;
	int maxDiameter = 1;
}

