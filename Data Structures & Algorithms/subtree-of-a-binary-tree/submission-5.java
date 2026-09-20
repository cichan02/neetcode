/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }

        if (subRoot == null) {
            return true;
        }

        return isSametree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSametree(TreeNode n1, TreeNode n2) {
        if (n1 == n2) {
            return true;
        }

        if (n1 == null || n2 == null) {
            return false;
        }

        return n1.val == n2.val && isSametree(n1.left, n2.left) && isSametree(n1.right, n2.right);
    }
}
