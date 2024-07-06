class Solution {
    public int passThePillow(int n, int time) {
        int turn = 1;
        boolean flag = false;
        while(time-- > 0) {
            if (turn == n) {
                flag = true;
            } else if (turn == 1) {
                flag = false;
            }
            if (flag) {
                turn--;
            } else {
                turn++;
            }
        }
        return turn;
    }
}