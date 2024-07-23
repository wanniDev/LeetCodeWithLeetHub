class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Integer[] numsObject = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsObject[i] = nums[i];
        }

        Arrays.sort(numsObject, (a, b) -> {
            if (map.get(a).equals(map.get(b))) {
                return b - a;
            }
            return map.get(a) - map.get(b);
        });

        return Arrays.stream(numsObject).mapToInt(Integer::intValue).toArray();
    }
}