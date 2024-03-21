package _코테준비_;

public class 스그래프_2 {
	static int maxDiameter = 0;

	public static int diameterOfBinaryTree(TreeNode root) {
		maxDepth(root);
		return maxDiameter;
	}

	private static int maxDepth(TreeNode node) {
		if (node == null)
			return 0;
		int left = maxDepth(node.left);
		int right = maxDepth(node.right);
		maxDiameter = Math.max(maxDiameter, left + right);
		return Math.max(left, right) + 1;
	}

	public static void main(String[] args) {
		// Example tree construction
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		System.out.println(diameterOfBinaryTree(root));
	}

}

class TreeNode {
	int val;
	TreeNode left, right;

	TreeNode(int x) {
		val = x;
	}
}