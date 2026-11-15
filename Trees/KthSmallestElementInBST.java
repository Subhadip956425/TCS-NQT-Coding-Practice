/////////////////////////////////////////

package Trees;

import java.util.*;

// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
public class KthSmallestElementInBST {

    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        while (true) {
            // go left as far as possible
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--; // visit one node
            if (k == 0) return root.val;
            root = root.right; // move to right subtree
        }
    }

    public static void main(String[] args) {
        KthSmallestElementInBST solver = new KthSmallestElementInBST();

        // Example: [5,3,6,2,4,null,null,1], k=3
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        System.out.println(solver.kthSmallest(root, 3)); // Output: 3
    }
}
