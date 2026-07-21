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
        int pivot = l;
        l = 0;
        r = nums.length - 1;
        if (nums[pivot] <= target && target <= nums[r]) {
            l = pivot;
        } else {
            r = pivot;
        }

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
