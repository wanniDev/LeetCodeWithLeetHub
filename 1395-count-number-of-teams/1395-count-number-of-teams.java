/**
백트래킹을 활용한 완전탐색으로 풀어봄.. 그러나
Time Limit Exceeded

(해설지 참고 - 캐시)
teamAscCache[인덱스][팀사이즈]
ex 
 */
class Solution {
    
    public int numTeams(int[] rating) {
        int len = rating.length;
        int teams = 0;
        Integer[][] ascCache = new Integer[len][4];
        Integer[][] descCache = new Integer[len][4];
        for (int i = 0; i < len; i++) {
            teams += scanAsc(rating, i, 1, ascCache) + scanDesc(rating, i, 1, descCache);
        }
        return teams;
    }

    private int scanAsc(int[] rating, int currIdx, int teamSize, Integer[][] cache) {
        int len = rating.length;

        if (currIdx == len) {
            return 0;
        }

        if (teamSize == 3) {
            return 1;
        }

        if (cache[currIdx][teamSize] != null) {
            return cache[currIdx][teamSize];
        }

        int validTeams = 0;
        for (int i = currIdx + 1; i < len; i++) {
            if (rating[i] > rating[currIdx]) {
                validTeams += scanAsc(rating, i, teamSize + 1, cache);
            }
        }

        cache[currIdx][teamSize] = validTeams;
        return cache[currIdx][teamSize];
    }
    private int scanDesc(int[] rating, int currIdx, int teamSize, Integer[][] cache) {
        int len = rating.length;

        if (currIdx == len) {
            return 0;
        }

        if (teamSize == 3) {
            return 1;
        }

        if (cache[currIdx][teamSize] != null) {
            return cache[currIdx][teamSize];
        }

        int validTeams = 0;
        for (int i = currIdx + 1; i < len; i++) {
            if (rating[i] < rating[currIdx]) {
                validTeams += scanDesc(rating, i, teamSize + 1, cache);
            }
        }

        cache[currIdx][teamSize] = validTeams;
        return cache[currIdx][teamSize];
    }
}