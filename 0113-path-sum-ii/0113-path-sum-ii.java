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
 /**
 dfs 문제
 
  */
class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root != null) {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            if (root.left == null && root.right == null && root.val == targetSum) {
                result.add(list);
                return result;
            }
            find(root, root.val, list, targetSum);
        }
        return result;
    }

    private void find(TreeNode node, int sum, List<Integer> list, int targetSum) {
        if (node.left != null) {
            list.add(node.left.val);
            find(node.left, sum + node.left.val, list, targetSum);
            list.remove(list.size() - 1);
        }

        if (node.right != null) {
            list.add(node.right.val);
            find(node.right, sum + node.right.val, list, targetSum);
            list.remove(list.size() - 1);
        }

        if (node.left == null && node.right == null) {
            if (sum == targetSum && list.size() > 1) {
                result.add(new ArrayList<>(list));
            }
        }
    }
}