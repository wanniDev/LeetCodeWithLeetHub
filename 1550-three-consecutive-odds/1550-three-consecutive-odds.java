// 배열안의 숫자가 연속해서 3번 이상 홀수임을 유지하면 true 아니면 false인 함수 구현하기
// 1. 배열을 순회한다.
// 2. 순회하면서 홀수를 카운팅한다.
// 3. 한번이라도 짝수가 카운팅되면, 홀수 카운팅을 초기화한다.
// 4. 초기화하는 시점에 홀수 카운팅이 3 이상이면, true리턴, 아니면 탐색을 계속한다.
// 5. 순회를 끝마친 이후, 홀수 카운팅이 3 이상이면 true 리턴 아니면 false 리턴
class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int cnt = 0;
        for (int num : arr) {
            if (num % 2 == 0) {
                if (cnt >= 3) {
                    return true;
                }
                cnt = 0;
            } else {
                cnt++;
            }
        }

        if (cnt >= 3) {
            return true;
        }
        return false;
    }
}