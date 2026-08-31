class Solution {
    public int search(final int[] nums, final int t) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) >>> 1;
            if (t == nums[m]) {
                return m;
            }

            if (nums[l] <= nums[m]) {
                if (nums[l] <= t && t < nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (nums[m] < t && t <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return -1;
    }
}
