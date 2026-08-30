class Solution {
    private int binarySearch(final int[] nums, final int t, final boolean isLower) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (t < nums[m] || (t == nums[m] && isLower)) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return isLower ? l : r;
    }

    public int[] searchRange(final int[] nums, final int t) {
        final int l = binarySearch(nums, t, true);
        final int r = binarySearch(nums, t, false);
        if (l > r) {
            return new int[]{-1, -1};
        }
        return new int[]{l, r};
    }
}