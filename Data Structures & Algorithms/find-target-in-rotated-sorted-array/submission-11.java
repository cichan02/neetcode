class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                return m;
            }

            if (nums[m] < nums[r]) {
                if (nums[m] > target || target > nums[r]) {
                    r = m;
                } else {
                    l = m + 1;
                }
            } else {
                if (nums[m] < target || target < nums[l]) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
        }
        return nums[l] == target ? l : -1;
    }
}
