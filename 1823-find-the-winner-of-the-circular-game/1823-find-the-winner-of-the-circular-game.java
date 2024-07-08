class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> players = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            players.add(i + 1);
        }

        int start = 0;
        while(players.size() > 1) {
            int remove = (start + k - 1) % players.size();
            players.remove(remove);
            start = remove;
        }
        return players.get(0);
    }
}