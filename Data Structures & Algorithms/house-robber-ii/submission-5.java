class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int zero = 0, first = 0, tmp, maxF;
        for (int num: nums) {
            tmp = Math.max(zero + num, first);
            zero = first;
            first = tmp;
        }

        maxF = first;
        for (int num: nums) {
            tmp = Math.max(zero + num, first);
            zero = first;
            first = tmp;
        }
        return first - maxF;
    }
}
