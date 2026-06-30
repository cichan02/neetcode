class Solution {
    public int[] productExceptSelf(int[] nums) {
        int l = nums.length;
        int[] res = new int[l];
        res[l-1] = nums[l-1];
        for (int i = l-2;i >=0; i--) {
            res[i] = res[i+1] * nums[i];
        }

        int prefix = nums[0];
        res[0] = res[1];
        for (int i = 1; i < l -1; i++) {
            res[i] = prefix * res[i+1];
            prefix *= nums[i];
        }
        res[l-1] = prefix;
        return res;
    }
}  
