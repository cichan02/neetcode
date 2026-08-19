class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = HashMap.newHashMap(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (numToIndex.containsKey(target - num)) {
                return new int[]{numToIndex.get(target - num), i};
            }
            numToIndex.put(num, i);
        }
        return new int[]{0, 1};
    }
}
