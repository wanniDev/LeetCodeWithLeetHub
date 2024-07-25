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
노드별 트리 순회경로를 문자열로 표현하고 해당 문자열과 동일한 패턴이 발견되는 노드를 수집
문자열 기본구조
(node.left.val)node.val(node.right.val)

동일한 패턴인지 확인하는 여부는 노드순회할때마다 해당 패턴 문자열과 갯수를 저장하는 map을 활용함.
갯수가 2개가 된다는 것은 동일한 패턴이 발생했다는 뜻이된다.
중복되는 패턴이 발생할때마다 기록할 필요는 없으므로 중복 발생여부는 2개째까지만 카운팅한다.
  */
class Solution {
    private String traverse(TreeNode node, Map<String, Integer> map, List<TreeNode> list) {
        if (node == null) {
            return "";
        }

        String signature = "(" + traverse(node.left, map, list) + ")" + node.val + "(" + traverse(node.right, map, list) + ")";
        map.put(signature, map.getOrDefault(signature, 0) + 1);
        if (map.get(signature) == 2) {
            list.add(node);
        }
        return signature;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new LinkedList<>();
        traverse(root, new HashMap<>(), result);
        return result;
    }
}