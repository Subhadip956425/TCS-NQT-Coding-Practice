package Trees;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
public class LowestCommonAncestorBST {
    
    // Definition for a binary tree node
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;  // both on left side
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right; // both on right side
            } else {
                return root;       // split point → LCA
            }
        }
        return null; // should not happen (p and q are guaranteed to exist)
    }

    public static void main(String[] args) {
        LowestCommonAncestorBST solver = new LowestCommonAncestorBST();

        // Build example: [6,2,8,0,4,7,9,null,null,3,5]
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        TreeNode p = root.left;   // 2
        TreeNode q = root.right;  // 8

        TreeNode lca = solver.lowestCommonAncestor(root, p, q);
        System.out.println("LCA: " + lca.val); // Output: 6
    }
}
