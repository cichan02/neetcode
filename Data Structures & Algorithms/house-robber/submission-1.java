class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        int[] res = new int[len+2];
        for (int i = 0; i < len; i++) {
            res[i+2] = Math.max(nums[i] + res[i], res[i+1]);
        }
        return res[len+1];
    }
}
