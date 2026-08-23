

class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        int[] res = new int[len+3];
        for (int i = len-1; i >= 0; i--) {
            res[i] = nums[i] + Math.max(res[i+2], res[i+3]);
        }
        return Math.max(res[0], res[1]);
    }
}
