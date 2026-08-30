class Solution {
    private int lowerBound(final int[] nums, final int t) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (t <= nums[m]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
    
    private int upperBound(final int[] nums, final int t) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (t < nums[m]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return r;
    }
    
    public int[] searchRange(final int[] nums, final int t) {
        int l = lowerBound(nums, t);
        int r = upperBound(nums, t);
        if (r < l) {
            return new int[]{-1, -1};
        }
        return new int[]{l, r};
    }
}