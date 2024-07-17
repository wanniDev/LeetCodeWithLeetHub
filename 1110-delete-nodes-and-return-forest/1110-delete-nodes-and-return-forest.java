/**
disjoint라는 말이 있어서, 잠깐 긴장했지만, disjoint set은 활용하지 않아도 되는 문제다.
다만, 리트코드에서 주어진 배열이 트리로 구성되는 매커니즘에 익숙하지 않은 사람은 이 문제가 좀 낯설 수 있다.

특정 노드가 지워지면, 해당 노드와 연결된 자식 노드들을 끊어지는 함수를 구현하면 되는데, 
TreeNode를 element로 하는 리스트를 선언하고
postOrder로 트리를 순회하여, to_delete에 해당하는 노드는 null 처리함으로서 노드가 지워지는걸 반영하고
리스트에 해당 노드의 왼쪽, 오른쪽 노드를 추가해줌으로서, 지워진 노드로 인해 흩어진 형태를 반영한다.
 */

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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int nodeVal : to_delete) {
            set.add(nodeVal);
        }
        root = process(root, set, result);

        if (root != null) {
            result.add(root);
        }

        return result;
    }

    private TreeNode process(TreeNode node, Set<Integer> set, List<TreeNode> result) {
        if (node == null) {
            return null;
        }

        node.left = process(node.left, set, result);
        node.right = process(node.right, set, result);

        if (set.contains(node.val)) {
            if (node.left != null) {
                result.add(node.left);
            }
            if (node.right != null) {
                result.add(node.right);
            }
            return null;
        }

        return node;
    }
}