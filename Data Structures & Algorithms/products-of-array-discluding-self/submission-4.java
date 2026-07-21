class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] to = new int[nums.length];
        to[0] = 1;
        int[] back = new int[nums.length];
        back[nums.length - 1] = 1;
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length - 1; i++) {
            to[i+1] = to[i] * nums[i];
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            back[i] = back[i+1] * nums[i+1];
        }

        for (int i = 0; i < nums.length; i++) {
            res[i] = to[i] * back[i];
        }
        return res;
    }
}  
