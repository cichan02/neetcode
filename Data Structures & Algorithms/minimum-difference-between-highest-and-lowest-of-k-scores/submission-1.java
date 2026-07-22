class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, res = Integer.MAX_VALUE;
        for (int r = k - 1; r < nums.length; r++) {
            res = Math.min(res, Math.abs(nums[r] - nums[l]));
            l++;
        }
        return res;
    }
}