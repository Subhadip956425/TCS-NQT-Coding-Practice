////////////////////////////////

package Trees;

// https://leetcode.com/problems/validate-binary-search-tree/
class ValidateBST {

    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long min, long max) {
        if (node == null) return true;

        if (node.val <= min || node.val >= max) return false;

        return validate(node.left, min, node.val) &&
               validate(node.right, node.val, max);
    }

    // Test
    public static void main(String[] args) {
        ValidateBST solver = new ValidateBST();

        // Example 1: [2,1,3] => true
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        System.out.println("Example 1: " + solver.isValidBST(root1)); // true

        // Example 2: [5,1,4,null,null,3,6] => false
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);
        System.out.println("Example 2: " + solver.isValidBST(root2)); // false
    }
}
