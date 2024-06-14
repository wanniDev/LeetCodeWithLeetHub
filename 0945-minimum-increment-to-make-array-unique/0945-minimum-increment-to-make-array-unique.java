class Solution {
    public int minIncrementForUnique(int[] nums) {
        // 정렬한다음, map으로 카운팅. 그리고 중복된 수 찾으면 맵에 포함되지 않는 값을 찾을때까지 move
        // [3,2,1,2,1,7]
        // [1,4,2,2,3,7] 3
        // [1,4,5,2,3,7] 3
        // map을 썼더니 timeLimitExceeded 오류 발생!
        // map을 쓰지말고, greedy하게 
        Arrays.sort(nums);
        int incrementCnt = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                nums[i]++;
                incrementCnt++;
            } else if (nums[i - 1] > nums[i]) {
                int temp = nums[i];
                nums[i] = nums[i - 1] + 1;
                incrementCnt += nums[i] - temp;
            }
        }
        return incrementCnt;
    }
}