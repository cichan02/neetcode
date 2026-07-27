class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> uniques = HashSet.newHashSet(nums.length);
        for (int l = 0, r = 0; r < nums.length; r++) {
            if (uniques.contains(nums[r])) {
                return true;
            }

            uniques.add(nums[r]);

            while (r - l + 1 > k) {
                uniques.remove(nums[l++]);
            }
        }
        return false;
    }
}