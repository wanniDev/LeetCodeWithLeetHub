/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 /**
 prev, curr, next 노드를 지정하고
 next 노드가 null이 아닐때까지 순회하면서
 local Minimum과 Maximum을 찾아낸다.

 삽질했던 부분...
 min, max를 구할때, 완전탐색을 수행해서 time limit 에러뜸
 max는 첫 부분과 끝 부분만 탐색해서 구하면 되지만, min값은 중간 노드간의 거리 중에서 가장 적은 값이 나올 수 있기때문에 다른 방법을 구해야했음.
 -> 고민결과, 문제에서 말한 critical point에 해당하는 node를 구할때마다 바로 이전 노드와의 거리를 구해서 min 값을 구함
  */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<int[]> list = new ArrayList<>();
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr.next;

        int pos = 1;
        int min = Integer.MAX_VALUE;
        while (next != null) {
            if (prev == null) {
                prev = curr;
                curr = curr.next;
                next = next.next;
                pos++;
                continue;
            }
            if (curr.val > prev.val && curr.val > next.val || curr.val < prev.val && curr.val < next.val) {
                list.add(new int[]{pos, curr.val});
                if (list.size() > 1) {
                    min = Math.min(min, list.get(list.size() - 1)[0] - list.get(list.size() - 2)[0]);
                }
            }
            prev = curr;
            curr = curr.next;
            next = next.next;
            pos++;
        }
        
        if (list.size() < 2) {
            return new int[]{-1, -1};
        }
        int max = list.get(list.size() - 1)[0] - list.get(0)[0];
        return new int[] {min, max};
    }
}