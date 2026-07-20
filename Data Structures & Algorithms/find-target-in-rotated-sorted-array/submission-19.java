class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (target == nums[m]) {
                return m;
            }

            if (nums[m] < nums[r]) {
                if (target < nums[m] || target > nums[r]) {
                    r = m;
                } else {
                    l = m + 1;
                }
            } else {
                if (target < nums[l] || target > nums[m]) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
        }
        return target == nums[l] ? l : -1;
    }
}
