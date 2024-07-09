/**
문제 풀이 자체는 예시의 설명을 참고하여 그대로 구현하면 된다.
단, 총 대기시간의 합이 정수의 범위를 넘어스는 경우에 대해 고려해야한다.
 */
class Solution {
    public double averageWaitingTime(int[][] customers) {
        int next = 0;
        long total = 0;
        for (int i = 0; i < customers.length; i++) {
            next = Math.max(next, customers[i][0]) + customers[i][1];
            total += next - customers[i][0];
        }
        System.out.println(total);
        double result = (double) total / customers.length;
        return result;
    }
}