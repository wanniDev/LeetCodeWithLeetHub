class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        
        Set<String> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            String str = list2[i];
            if (map.containsKey(str)) {
                set.add(str);
                int sum = map.get(str) + i;
                map.put(str, sum);
                min = Math.min(min, sum);
            }
        }
        
        List<String> list = new ArrayList<>();
        for (String str : set) {
            if (map.get(str) == min) {
                list.add(str);
            }
        }
        
        String[] result = new String[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}