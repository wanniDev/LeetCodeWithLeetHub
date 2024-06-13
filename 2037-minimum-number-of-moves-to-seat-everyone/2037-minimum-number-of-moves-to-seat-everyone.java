// counting sort - 
class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        int maxPosition = 0;
        for (int pos : seats) {
            maxPosition = Math.max(maxPosition, pos);
        }

        for (int pos : students) {
            maxPosition = Math.max(maxPosition, pos);
        }

        int[] difference = new int[maxPosition];
        for (int pos : seats) {
            difference[pos - 1]++;
        }

        for (int pos : students) {
            difference[pos - 1]--;
        }

        int moves = 0;
        int unmatches = 0;
        for (int diff : difference) {
            moves += Math.abs(unmatches);
            unmatches += diff;
        }

        return moves;
    }
}