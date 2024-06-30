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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return find(root, root.val, targetSum);
    }

    private boolean find(TreeNode node, int sum, int targetSum) {

        if (node.left != null && node.right != null) {
            return find(node.left, sum + node.left.val, targetSum) || find(node.right, sum + node.right.val, targetSum);
        }

        if (node.left != null && node.right == null) {
            return  find(node.left, sum + node.left.val, targetSum);
        }

        if (node.right != null && node.left == null) {
            return  find(node.right, sum + node.right.val, targetSum);
        }

        if (sum == targetSum) {
            return true;
        }

        return false;
    }
}