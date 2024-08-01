/*
처음 10문자             |
7868190130(phoneNumber) M(gender) 75(age) 22(seatNumber)
*/
class Solution {
    public int countSeniors(String[] details) {
        int len = details.length;
        int[] ages = new int[len];
        for (int i = 0; i < len; i++) {
            String detail = details[i];
            ages[i] = Integer.parseInt(detail.substring(11, 13));
        }
        
        int result = 0;
        for (int age : ages) {
            if (age > 60) {
                result++;
            }
        }
        return result;
    }
}