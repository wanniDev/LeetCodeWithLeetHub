class Solution {
    // 해피넘버의 조건
    // 1. 각 자리의 수를 제곱한 다음 그 수의 총합을 구한다.
    // 2. 계속 반복하면서 결과가 1이 나오면 해피넘버이다.
    //
    // 풀이
    // '해피넘버 연산'을 결과가 1이거나 기존의 수가 나올때까지 반복한다.
    // 1이 나오면 해피넘버이니, true를 리턴하고, 기존의 수가 나온다는 것은 무한루프로 1이 절대 나오지 않는다는 뜻이니, false를 리턴한다.
    // Set을 활용하여 해피넘버 연산 중 되풀이 되는 수가 있는지 확인한다.

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = happyPow(n);
        }
        return n == 1;
    }
    
    private int happyPow(int n) {
        int result = 0;
        while (n != 0) {
            int d = n % 10;
            result += d * d;
            n /= 10;
        }
        return result;
    }
}