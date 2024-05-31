class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        
        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();

        for (int i = 0; i < sarr.length; i++) {
            char sc = sarr[i];
            char tc = tarr[i];
            
            sMap.putIfAbsent(sc, tc);
            tMap.putIfAbsent(tc, sc);

            if (sMap.get(sc) != tc || tMap.get(tc) != sc) {
                return false;
            }
        }
        return true;
    }
}