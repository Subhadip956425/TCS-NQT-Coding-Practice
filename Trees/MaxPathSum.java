/// ////////////////////////////////////////

package Trees;

class MaxPathSum {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }

    // Returns the max path sum **from this node to leaf** (single branch)
    private int helper(TreeNode node) {
        if (node == null) return 0;

        // Only consider positive contributions
        int leftMax = Math.max(helper(node.left), 0);
        int rightMax = Math.max(helper(node.right), 0);

        // Max path through the current node (may include both children)
        int currentMax = node.val + leftMax + rightMax;

        // Update global max
        maxSum = Math.max(maxSum, currentMax);

        // Return max sum for path **starting at this node** going upwards
        return node.val + Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        MaxPathSum solver = new MaxPathSum();

        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println("Max Path Sum: " + solver.maxPathSum(root)); // 42
    }
}
