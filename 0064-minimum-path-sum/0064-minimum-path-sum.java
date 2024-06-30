class Solution {
    /*
    dp 점화식으로 최소 합계 구하기

    1 4 5
    2 7 6
    6 8 7
    */
    public int minPathSum(int[][] grid) {
        for (int i = 1; i < grid[0].length; i++) {
            grid[0][i] += grid[0][i - 1];
        }

        for (int i = 1; i < grid.length; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        for (int r = 1; r < grid.length; r++) {
            for (int c = 1; c < grid[0].length; c++) {
                grid[r][c] += Math.min(grid[r - 1][c], grid[r][c - 1]); 
            }
        }

        return grid[grid.length - 1][grid[0].length - 1];
    }
}