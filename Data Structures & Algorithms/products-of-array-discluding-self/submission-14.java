class Solution {
    public int[] productExceptSelf(int[] nums) {
        int l = nums.length;
        int[] res = new int[l];

        res[l-1] = nums[l-1];
        for (int i = l - 2; i >= 0; i--) {
            res[i] = res[i+1] * nums[i];
        }

        int pref = nums[0];
        res[0] = res[1];
        for (int i = 1; i < l - 1; i++) {
            res[i] = res[i+1] * pref;
            pref *= nums[i];
        }
        res[l - 1] = pref;

        return res;
    }
}  
