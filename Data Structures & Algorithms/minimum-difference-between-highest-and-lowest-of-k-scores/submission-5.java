class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, res = Integer.MAX_VALUE;
        for (int r = 0; r < nums.length; r++) {
            if (r - l + 1 >= k) {
                res = Math.min(res, nums[r] - nums[l++]);
            }
        }
        return res;
    }
}