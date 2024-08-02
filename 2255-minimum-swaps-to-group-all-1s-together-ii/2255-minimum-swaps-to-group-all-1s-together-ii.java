/**
1의 갯수를 센다
0의 갯수를 센다

'Using Suffix Sum 공부하고 다시 살펴보기'
 */
class Solution {
    public int minSwaps(int[] nums) {
        int op1 = scan(nums, 0);
        int op2 = scan(nums, 1);
        return Math.min(op1, op2);
    }

    private int scan(int[] nums, int val) {
        int len = nums.length;
        int[] rightSuffixSum = new int[len + 1];
        for (int i = len - 1; i >= 0; i--) {
            rightSuffixSum[i] = rightSuffixSum[i + 1];
            if (nums[i] == (val ^ 1)) rightSuffixSum[i]++;
        }
        int totalSwapsNeeded = rightSuffixSum[0];
        int currentSwapCount = 0;
        int minimumSwaps = totalSwapsNeeded - rightSuffixSum[len - totalSwapsNeeded];

        for (int i = 0; i < totalSwapsNeeded; i++) {
            if (nums[i] == (val ^ 1)) {
                currentSwapCount++;
            }
            int remaining = (totalSwapsNeeded - i - 1);
            int requiredSwaps =
                ((i + 1) - currentSwapCount) +
                (remaining - rightSuffixSum[len - remaining]);
            minimumSwaps = Math.min(minimumSwaps, requiredSwaps);
        }
        return minimumSwaps;
    }
}