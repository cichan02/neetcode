class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> numToIndex = HashMap.newHashMap(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(i - numToIndex.getOrDefault(nums[i], Integer.MAX_VALUE)) <= k) {
                return true;
            }
            numToIndex.put(nums[i], i);
        }
        return false;
    }
}