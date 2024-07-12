/**
부분 문자열을 지워서 최대의 점수를 얻는 함수를 구현하는 문제
즉, 높은 점수를 주는 부분 문자열을 제일 우선적으로 지워가며

substring의 최초 시작점을 기준으로 더 높은 점수의 부분 문자열을 먼저 지운 다음에
그 다음 부분 문자열을 지운다음
점수를 카운팅해서 리턴한다.

stack의 원리를 활용해서 기준 부분 문자열을 제외하고 모든 문자열을 쌓는다.
stack을 직접 사용하기보다는 StringBuilder를 사용해본다.
x = 4, y = 5
cdbcb'ba'aabab  5
cdbc'ba'abab    5
cdbca'ba'b      5
cdbc'ab'        4

5 + 5 + 5 + 4 = 19

x = 5, y = 4
aabbaaxybbaabb
aa
 */
class Solution {
    int result = 0;

    public int maximumGain(String s, int x, int y) {
        String sub1 = "ab";
        String sub2 = "ba";
        int score1 = x;
        int score2 = y;
        if (y > x) {
            String temp = "ab";
            sub1 = sub2;
            sub2 = temp;
            int temp2 = score1;
            score1 = score2;
            score2 = temp2;
        }

        s = scan(s, sub1, score1);
        s = scan(s, sub2, score2);

        return result;
    }

// aabbaaxybbaabb
    private String scan(String s, String sub, int score) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++) {
            if (!sb.isEmpty() 
                && sb.charAt(sb.length() - 1) == sub.charAt(0)
                && arr[i] == sub.charAt(1)
            ) {
                sb.deleteCharAt(sb.length() - 1);
                result += score;
            } else {
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }
}