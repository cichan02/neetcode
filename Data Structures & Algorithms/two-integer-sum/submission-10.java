class Solution {
    public int[] twoSum(final int[] nums, final int t) {
        Map<Integer, Integer> numToIndex = HashMap.newHashMap(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int diff = t - nums[i];
            if (numToIndex.containsKey(diff)) {
                return new int[]{numToIndex.get(diff), i};
            }
            numToIndex.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
