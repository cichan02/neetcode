class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        for (int l = 0, r = k-1; r < nums.length; l++, r++) {
            minDiff = Math.min(minDiff, nums[r] - nums[l]);
        }
        return minDiff;
    }
}