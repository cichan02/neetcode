class Solution {
    private int lowerBound(int[] nums, int t) {
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
    
    private int upperBound(int[] nums, int t) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (t < nums[m]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
    
    public int[] searchRange(int[] nums, int target) {
        int l = lowerBound(nums, target);
        int r = upperBound(nums, target);
        if (r <= l) return new int[] {-1, -1};
        return new int[] {l, r - 1};
    }
}