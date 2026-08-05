class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] postfix  = new int[len];
        postfix[len-1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            postfix[i] = postfix[i + 1] * nums[i + 1];
        }

        int prefix = 1;
        for (int i = 0; i  < len; i++) {
            int temp = nums[i];
            nums[i] = prefix * postfix[i];
            prefix *= temp;
        }
        return nums;
    }
}  
