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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        Map<Integer, TreeNode> parentMap = new HashMap<>();
        populateParentMap(root, parentMap);

        TreeNode startNode = findStartNode(root, startValue);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(startNode);
        Set<Integer> visited = new HashSet<>();
        
        Map<TreeNode, Pair<TreeNode, String>> pathTracker = new HashMap<>();
        visited.add(startNode.val);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current.val == destValue) {
                return backtrace(current, pathTracker);
            }

            if (parentMap.containsKey(current.val)) {
                TreeNode parent = parentMap.get(current.val);
                if (!visited.contains(parent.val)) {
                    queue.offer(parent);
                    pathTracker.put(parent, new Pair(current, "U"));
                    visited.add(parent.val);
                }
            }

            if (current.left != null && !visited.contains(current.left.val)) {
                queue.offer(current.left);
                pathTracker.put(current.left, new Pair(current, "L"));
                visited.add(current.left.val);
            }

            if (current.right != null && !visited.contains(current.right.val)) {
                queue.offer(current.right);
                pathTracker.put(current.right, new Pair(current, "R"));
                visited.add(current.right.val);
            }
        }

        return "";
    }

    private String backtrace(TreeNode node, Map<TreeNode, Pair<TreeNode, String>> pathTracker) {
        StringBuilder sb = new StringBuilder();

        while (pathTracker.containsKey(node)) {
            sb.append(pathTracker.get(node).getValue());
            node = pathTracker.get(node).getKey();
        }
        sb.reverse();

        return sb.toString();
    }

    private TreeNode findStartNode(TreeNode node, int startValue) {
        if (node == null) {
            return null;
        }

        if (node.val == startValue) {
            return node;
        }

        TreeNode leftNode = findStartNode(node.left, startValue);
        
        if (leftNode != null) {
            return leftNode;
        }
        return findStartNode(node.right, startValue);
    }

    private void populateParentMap(TreeNode node, Map<Integer, TreeNode> map) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            map.put(node.left.val, node);
            populateParentMap(node.left, map);
        }

        if (node.right != null) {
            map.put(node.right.val, node);
            populateParentMap(node.right, map);
        }
    }
}