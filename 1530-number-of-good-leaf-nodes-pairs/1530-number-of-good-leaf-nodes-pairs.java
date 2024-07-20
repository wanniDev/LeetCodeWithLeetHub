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
 그래프 생성 + bfs

 트리 노드를 그래프로 형성하고

 리프노드부터 주어진 distance만큼 탐색하여 다른 리프노드에 도착할 수 있는 경우를 카운팅하여 해당 값을 리턴한다.
  */
class Solution {
    public int countPairs(TreeNode root, int distance) {
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        Set<TreeNode> leafNodes = new HashSet<>();

        traverse(root, null, graph, leafNodes);

        int result = 0;

        for (TreeNode leaf : leafNodes) {
            Queue<TreeNode> q = new LinkedList<>();
            Set<TreeNode> visited = new HashSet<>();
            q.add(leaf);
            visited.add(leaf);
            for (int i = 0; i <= distance; i++) {
                int len = q.size();
                for (int j = 0; j < len; j++) {
                    TreeNode curr = q.poll();
                    if (leafNodes.contains(curr) && curr != leaf) {
                        result++;
                    }
                    if (graph.containsKey(curr)) {
                        for (TreeNode neighbor : graph.get(curr)) {
                            if (!visited.contains(neighbor)) {
                                q.add(neighbor);
                                visited.add(neighbor);
                            }
                        }
                    }
                }
            }
        }

        return result / 2;
    }

    private void traverse(
        TreeNode node, 
        TreeNode prev, 
        Map<TreeNode, List<TreeNode>> graph, 
        Set<TreeNode> leafNodes
    ) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            leafNodes.add(node);
        }

        if (prev != null) {
            graph.putIfAbsent(prev, new ArrayList<>());
            graph.get(prev).add(node);
            graph.putIfAbsent(node, new ArrayList<>());
            graph.get(node).add(prev);
        }
        traverse(node.left, node, graph, leafNodes);
        traverse(node.right, node, graph, leafNodes);
    }
}