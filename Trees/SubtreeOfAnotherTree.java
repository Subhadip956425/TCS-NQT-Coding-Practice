package Trees;

// https://leetcode.com/problems/subtree-of-another-tree/
class SubtreeOfAnotherTree {

    // Definition for a binary tree node
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    // Main function
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;  // empty big tree
        if (isSameTree(root, subRoot)) return true; // match found
        // check left or right subtrees
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // Helper: check if two trees are identical
    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        SubtreeOfAnotherTree solver = new SubtreeOfAnotherTree();

        // Root: [3,4,5,1,2]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        // SubRoot: [4,1,2]
        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);

        System.out.println("Is subRoot a subtree of root? " + solver.isSubtree(root, subRoot)); // true
    }
}
