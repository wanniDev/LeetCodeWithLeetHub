/**
최대값과 최소값
풀이: 사용하지 않을 최대값과 최소값의 위치를 3번 지정한 다음 최대값 - 최소값의 답들을 구한다음 그 중에서 가장 최소값을 탐색하여 리턴하다.

위 풀이는 총 4가지의 경우로 나눌 수 있다.
        ㅇ ㅇ ㅇ
0, 1, 2, 3, 4, 5
-> 2 - 0 = 2
ㅇ          ㅇ ㅇ
0, 1, 2, 3, 4, 5
-> 3 - 1 = 2
ㅇ ㅇ           ㅇ
0, 1, 2, 3, 4, 5
-> 4 - 2 = 2
ㅇ ㅇ ㅇ
0, 1, 2, 3, 4, 5
-> 5 - 3 = 2

답 : 2

1, 2, 3

위 풀이대로 진행하려면 주어진 모든 배열은 오름차순으로 정렬되어야 한다.
 */
class Solution {
    public int minDifference(int[] nums) {
        if (nums.length <= 4) {
            return 0;
        }
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        for (int l = 0, r = nums.length - 4; r < nums.length; l++, r++) {
            int difference = nums[r] - nums[l];
            result = Math.min(result, difference);
        }
        return result;
    }
}