class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int n = rowSum.length;
        int m = colSum.length;

        int[] currRowSum = new int[n];
        int[] currColSum = new int[m];
        int[][] arr = new int[n][m];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                arr[r][c] = Math.min(rowSum[r] - currRowSum[r], colSum[c] - currColSum[c]);
                currRowSum[r] += arr[r][c];
                currColSum[c] += arr[r][c]; 
            }
        }
        return arr;
    }
}