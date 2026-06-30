class Solution {
    public int[] productExceptSelf(int[] nums) {
        int l = nums.length;

        int[] postfix = new int[l];
        postfix[l - 1] = nums[l - 1];
        for (int i = l - 2; i >= 0; i--) {
            postfix[i] = postfix[i+1] * nums[i];
        }

        int[] res = new int[l];
        res[0] = postfix[1];
        int prefix = nums[0];
        for (int i = 1; i < l - 1; i++) {
            res[i] = prefix * postfix[i+1];
            prefix *= nums[i];
        }
        res[l-1] = prefix;
        return res;
    }
}  
