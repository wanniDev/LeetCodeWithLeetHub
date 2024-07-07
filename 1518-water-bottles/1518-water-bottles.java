/*
그냥 산수문제.
물을 최대한 많이 마시는 방법은 전부 다 마시고 -> 교환하기를 반복하는 것이다.
따라서
처음엔 주어진 물을 다 비운다. (total에 초기 병 갯수 합산)
교환 가능한 물의 갯수는 numExchange 나누기 연산으로 구할 수 있다.
교환이후 남는 빈 물통의 갯수는 numExchange 모듈러 연산으로 구할 수 있다.
즉, total에 주어진 물통 / 교환 갯수를 더하고, 더한 값과 기존의 남는 빈 물통의 갯수를 더하는 행위를 교환 단위보다 더 적은 물통이 남을때까지 반복한다.
*/
class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int total = numBottles;
        int emptyBottle = numBottles;
        while (emptyBottle >= numExchange) {
            int exchange = emptyBottle / numExchange;
            int remain = emptyBottle % numExchange;
            total += exchange;
            emptyBottle = exchange + remain;
        }
        return total;
    }
}