class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        return Math.max(rob(0, len - 1, nums), rob(1, len, nums));
    }


    private int rob(int start, int end, int[] nums) {
        int zero = 0, first = 0;
        for (int i = start; i < end; i++) {
            int tmp = first;
            first = Math.max(zero + nums[i], first);
            zero = tmp;
        }
        return first;
    }
}
