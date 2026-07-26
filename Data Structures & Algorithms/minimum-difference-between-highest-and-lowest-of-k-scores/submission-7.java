class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for (int l = 0, r = k - 1; r < nums.length; l++, r++) {
            res = Math.min(res, nums[r] - nums[l]);
        }
        return res;
    }
}