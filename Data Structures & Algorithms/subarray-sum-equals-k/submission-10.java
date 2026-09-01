public class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0, res = 0;
        HashMap<Integer, Integer> prefixSums = HashMap.newHashMap(nums.length);
        prefixSums.put(0, 1);

        for (int num : nums) {
            sum += num;

            int key = sum - k;

            res += prefixSums.getOrDefault(key, 0);
            prefixSums.put(sum, prefixSums.getOrDefault(sum, 0) + 1);
        }

        return res;
    }
}
