/*
substring 함수와 해시맵 사용 -> 타임 리미트...

그런데.. substring 함수를 꼭 써야했을까?
어차피 이중 포문으로 순회하면 결과적으로는 모든 부분 문자열을 탐색하게 되어있다.
*/
class Solution {
    public int beautySum(String s) {
        int sum = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int[] charCount = new int[26];
            
            for (int j = i; j < s.length(); ++j) {
                ++charCount[s.charAt(j) - 'a'];
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                for (int k = 0; k < charCount.length; k++) {
                    if (charCount[k] != 0) {
                        min = Math.min(min, charCount[k]);
                    }
                    max = Math.max(max, charCount[k]);
                }
				int beauty = max - min;
                sum += beauty;
            }
        }
        
        return sum;
    }
}