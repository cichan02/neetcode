class Solution {
    public int[] productExceptSelf(int[] nums) {
        long product = 1;
        int zeroIndex = -1;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (zeroIndex == -1) {
                    zeroIndex = i;
                    continue;
                } else {
                    return res;
                }
            }
            product *= nums[i];
        }

        if (zeroIndex != -1) {
            res[zeroIndex] = (int) product;
            return res;
        }

        for (int i = 0; i < nums.length; i++) {
            res[i] = (int) (product / nums[i]);
        }
        return res;
    }
}  
