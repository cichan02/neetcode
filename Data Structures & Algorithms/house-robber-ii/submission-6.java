class Solution {
    public int rob(final int[] nums) {
        final int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, len-1), rob(nums, 1, len));
    }

    private int rob(final int[] nums, final int start, final int stop) {
        int zero = 0, first = 0, tmp;
        for (int i = start; i < stop; i++) {
            tmp = Math.max(nums[i] + zero, first);
            zero = first;
            first = tmp;
        }
        return first;
    }
}
