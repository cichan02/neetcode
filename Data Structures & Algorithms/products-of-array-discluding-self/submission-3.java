class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zeroIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (zeroIndex == -1) {
                    zeroIndex = i;
                    continue;
                } else {
                    return new int[nums.length];
                }
            }
            product *= nums[i];
        }

        int[] res = new int[nums.length];
        if (zeroIndex != -1) {
            res[zeroIndex] = product;
            return res;
        }

        for (int i = 0; i < nums.length; i++) {
            res[i] = product / nums[i];
        }
        return res;
    }
}  
