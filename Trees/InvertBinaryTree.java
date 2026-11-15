package Trees;

// https://leetcode.com/problems/invert-binary-tree/
class InvertBinaryTree {
    
    // Definition for a binary tree node
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    // Recursive solution
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        
        // Swap children
        TreeNode temp = root.left;

        root.left = invertTree(root.right);
        root.right = invertTree(temp);

        return root;
    }

    // Helper: Print tree (inorder)
    public void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        InvertBinaryTree solver = new InvertBinaryTree();

        // Build tree: [4,2,7,1,3,6,9]
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        System.out.print("Original Inorder: ");
        solver.printInorder(root);

        solver.invertTree(root);

        System.out.print("\nInverted Inorder: ");
        solver.printInorder(root);
    }
}
