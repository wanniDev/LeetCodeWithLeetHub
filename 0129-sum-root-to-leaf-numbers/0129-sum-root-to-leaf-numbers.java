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

// 트리를 순회하면서 숫자를 만들고, 트리가 리프노드까지 다다르면 만든 숫자를 종합한다.
class Solution {
    private int sum;
    public int sumNumbers(TreeNode root) {
        scan(root, 0);
        return sum;
    }

    private void scan(TreeNode node, int current) {
        if (node != null) {
            current = current * 10 + node.val;
            if (node.left == null && node.right == null) {
                sum += current;
            }
            scan(node.left, current);
            scan(node.right, current);
        }
    }
}