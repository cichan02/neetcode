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
    public int maxDepth(TreeNode root) {
        int maxL = 0;

        if (root == null) {
            return maxL;
        }

        Queue<TreeNode> levels = new ArrayDeque<>();
        levels.add(root);
        while (!levels.isEmpty()) {
            int size = levels.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = levels.poll();
                if (tmp.left != null) {
                    levels.add(tmp.left);
                }
                if (tmp.right != null) {
                    levels.add(tmp.right);
                }
            }
            maxL++;
        }
        return maxL;
    }
}
