class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0, count = 0;
        Map<Integer, Integer> pref = HashMap.newHashMap(nums.length);
        pref.put(0, 1);

        for (int num: nums) {
            sum += num;

            int key = sum - k;

            count += pref.getOrDefault(key, 0);
            pref.merge(sum, 1, Integer::sum);
        }

        return count;
    }
}