class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> uninw = HashSet.newHashSet(nums.length);
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            if (r - l > k) {
                uninw.remove(nums[l]);
                l++;
            }

            if (uninw.contains(nums[r])) {
                return true;
            }

            uninw.add(nums[r]);
        }
        return false;
    }
}