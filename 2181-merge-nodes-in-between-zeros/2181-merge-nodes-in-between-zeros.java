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
 노드를 순회하면서, 0과 0사이의 노드들을 합친 결과를 리턴하는 함수

 조건
 1. 주어진 연결리스트의 시작과 끝은 0으로 이루어져있다.
 2. 0인 node가 2번이상 연속으로 이어지는 경우는 없다.
 3. 0이 아닌 node는 merge 된다.

 풀이
 2개의 포인터를 활용하여, 두개의 포인터 모두 0이 아닌 최초의 노드를 가리키고, 하나는 리스트를 이루는데 사용하고 다른 하나는 0이 아닌 노드들을 탐색하며 합치는 역할을 한다.

1. '탐색 포인터가 0이 아닌 노드를 가리킬때까지 해당 노드들의 합을 계산한다.'
2. 탐색 포인터가 0인 노드를 가리키는 순간 구성 포인터에게 값을 할당한 다음 두 포인터가 다음 포인터를 가리키도록 한다.
  */
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode compositNode = head.next;
        ListNode searchNode = compositNode;
        while (searchNode != null) {
            int sum = 0;
            while (searchNode.val != 0) {
                sum += searchNode.val;
                searchNode = searchNode.next;
            }
            searchNode = searchNode.next;
            compositNode.val = sum;
            compositNode.next = searchNode;
            compositNode = compositNode.next;
        }
        return head.next;
    }
}