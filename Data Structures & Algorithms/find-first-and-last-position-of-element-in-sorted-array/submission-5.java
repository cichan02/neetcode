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

    private int binarySearch(final int[] nums, final int t, final boolean isLower) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (t < nums[m]) {
                r = m - 1;
            } else if (t > nums[m]) {
                l = m + 1;
            } else {
                if (isLower) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }
        return isLower ? l : r;
    }
    
    public int[] searchRange(final int[] nums, final int t) {
        int l = binarySearch(nums, t, true);
        int r = binarySearch(nums, t, false);
        if (r < l) {
            return new int[]{-1, -1};
        }
        return new int[]{l, r};
    }
}