class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            List<Integer> list = map.getOrDefault(num, new ArrayList<>());
            list.add(i);
            map.put(num, list);
        }
        
        for (int num : map.keySet()) {
            List<Integer> list = map.get(num);
            for (int i = 0; i < list.size() - 1; i++) {
                int num1 = list.get(i);
                for (int j = i + 1; j < list.size(); j++) {
                    int num2 = list.get(j);
                    int sum = Math.abs(num1 - num2);
                    if (sum <= k) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
}