class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r  = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] < nums[r]) {
                r = m ;
            } else {
                l = m + 1;
            }
        }
        r = nums.length - 1;
        if (nums[l] <= target && target <= nums[r]) {
            while (l < r) {
                int m = l + (r - l) / 2;
                if (target <= nums[m]) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            return nums[l] == target ? l : -1;
        } else {
            r = l;
            l = 0;
            while (l < r) {
                int m = l + (r - l) / 2;
                if (target <= nums[m]) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            return nums[l] == target ? l : -1;
        }
    }
}
