class Solution {
    private char shiftCharacter(char ch, int shift) {
        return (char) ((ch - shift + 26) % 26 + 'a');
    }

    private String getHash(String str) {
        char[] arr = str.toCharArray();
        int shift = arr[0];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = shiftCharacter(arr[i], shift);
        }
        return String.valueOf(arr);
    }

    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strings) {
            String key = getHash(str);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> list : map.values()) {
            result.add(list);
        }

        return result;
    }
}