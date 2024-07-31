/**
thickness - 너비
주어진 책들을 쌓을때 가장 낮은 높이를 구해라....
-> 가장 얆고 낮은 책을 최대한 한 층에 우겨넣어야한다.

책 최대 높이 = 1000 * 1000 = 1M
서랍 최대 너비 1000

책의 너비 오름차순으로 정렬 (만약 너비가 같다면 낮은 높이를 오름차순)
정렬된 책들을 순회한다.
    서랍의 너비가 허용될때까지 한층에 넣는다.
    넣는 과정에서 최대 높이를 갱신한다.
    너비를 넘어서는 시점에 최대 높이만큼 층을 높인다.
높인 층수들의 합을 리턴한다.

ㄴㄴ 이거 dp 탑다운임...
 */
class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int[][] dp = new int[books.length][shelfWidth + 1];
        return scan(books, shelfWidth, dp, 0, shelfWidth, 0);
    }

    private int scan(int[][] books, int shelfWidth, int[][] dp, int i, int remainingShelfWidth, int maxHeight) {
        int[] currentBook = books[i];
        int maxHeightUpdate = Math.max(maxHeight, currentBook[1]);
        if (i == books.length - 1) {
            // 마지막 책을 씌워야할 시점에
            if (remainingShelfWidth >= currentBook[0]) {
                return maxHeightUpdate;
            }
            return maxHeight + currentBook[1];
        }

        if (dp[i][remainingShelfWidth] != 0) {
            return dp[i][remainingShelfWidth];
        } else {
            int height1 = maxHeight + scan(books, shelfWidth, dp, i + 1, shelfWidth - currentBook[0], currentBook[1]);
            if (remainingShelfWidth >= currentBook[0]) {
                int height2 = scan(books, shelfWidth, dp, i + 1, remainingShelfWidth - currentBook[0], maxHeightUpdate);
                dp[i][remainingShelfWidth] = Math.min(height1, height2);
                return dp[i][remainingShelfWidth];
            }
            dp[i][remainingShelfWidth] = height1;
            return dp[i][remainingShelfWidth];
        }


    }
}