class Solution {
    public int[] productExceptSelf(int[] nums) {
        int l = nums.length;

        int[] prefix = new int[l];
        prefix[0] = nums[0];
        for (int i = 1; i < l; i++) {
            prefix[i] = prefix[i-1] * nums[i];
        }

        int[] postfix = new int[l];
        postfix[l - 1] = nums[l - 1];
        for (int i = l - 2; i >= 0; i--) {
            postfix[i] = postfix[i+1] * nums[i];
        }

        int[] res = new int[l];
        res[0] = postfix[1];
        res[l-1] = prefix[l-2];
        for (int i = 1; i < l - 1; i++) {
            res[i] = prefix[i-1] * postfix[i+1];
        }
        return res;
    }
}  
