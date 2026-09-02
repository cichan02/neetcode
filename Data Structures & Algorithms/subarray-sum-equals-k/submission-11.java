class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0, count = 0;
        Map<Integer, Integer> prefix = HashMap.newHashMap(nums.length);
        prefix.put(0, 1);

        for (int num: nums) {
            sum += num;

            int key = sum - k;

            count += prefix.getOrDefault(key, 0);
            prefix.merge(sum, 1, Integer::sum);
        }

        return count;
    }
}