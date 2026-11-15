package Trees;

// https://leetcode.com/problems/same-tree/
class SameTree {

    // Definition for a binary tree node
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    // Recursive solution
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;   // both empty
        if (p == null || q == null) return false;  // one empty, one not
        if (p.val != q.val) return false;          // different values
        
        // check both subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        SameTree solver = new SameTree();

        // Tree p: [1,2,3]
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        // Tree q: [1,2,3]
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        System.out.println("Are trees same? " + solver.isSameTree(p, q)); // true
    }
}
