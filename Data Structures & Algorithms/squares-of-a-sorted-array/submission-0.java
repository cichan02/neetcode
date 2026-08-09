class Solution {
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int l = -1, r = 0;
        while (r < len && nums[r] < 0) {
            l++;
            r++;
        }

        int[] res = new int[len];
        int i = 0;
        while (l >= 0 && r < len) {
            if (Math.abs(nums[r]) < Math.abs(nums[l])) {
                res[i] = nums[r] * nums[r];
                r++;
            } else {
                res[i] = nums[l] * nums[l];
                l--;
            }
            i++;
        }

        for (int j = r; j < len; j++, i++) {
            res[i] = nums[j] * nums[j];
        }
        for (int j = l; j >= 0; j--, i++) {
            res[i] = nums[j] * nums[j];
        }
        return res;
    }
}