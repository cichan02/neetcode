class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        int suff = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            res[i+1] = res[i] * nums[i];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= suff;
            suff *= nums[i];
        }

        return res;
    }
}  
