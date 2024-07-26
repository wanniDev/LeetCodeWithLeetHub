/**
박스를 회전시키는 함수 구현
중력을 적용시키는 함수 구현

박스 회전
n x m -> m x n
1. m x n 배열 생성
2.기존 배열의 (r, c) 요소를 회전된 배열에 (c, r)로 옮긺
배열이 회전하면, 맨위의 행이 맨 마지막 열이되므로
r, c -> c, n - 1 - r 로 바뀐다.

중력 적용하기


 */
class Solution {
    private final char stone = '#';
    private final char air = '.';
    private final char block = '*';

    public char[][] rotateTheBox(char[][] box) {
        int n = box.length;
        int m = box[0].length;
        char[][] rotated = new char[m][n];
        Deque<int[]> stack = new ArrayDeque<>();
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                char element = box[r][c];
                rotated[c][n - 1 - r] = element;
            }
        }

        for (int c = 0; c < n; c++) {
            int empty = m - 1;
            for (int r = m - 1; r >= 0; r--) {
                if (rotated[r][c] == block) {
                    empty = r - 1;
                } else if (rotated[r][c] == stone) {
                    rotated[r][c] = air;
                    rotated[empty][c] = stone;
                    empty--;
                }
            }
        }

        return rotated;
    }
}