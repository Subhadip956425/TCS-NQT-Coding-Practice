package Trees;

// https://leetcode.com/problems/maximum-depth-of-binary-tree/
class MaximumDepthBinaryTree {
    
    // Definition for a binary tree node
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    // Recursive DFS solution
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return 1+Math.max(leftDepth, rightDepth);
    }

    public static void main(String[] args) {
        MaximumDepthBinaryTree solver = new MaximumDepthBinaryTree();

        // Example tree: [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println("Maximum Depth: " + solver.maxDepth(root)); // Output: 3
    }
}
