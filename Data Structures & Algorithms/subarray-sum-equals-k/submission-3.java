public class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0, res = 0;
        HashMap<Integer, Integer> map = HashMap.newHashMap(nums.length);
        map.put(0, 1);

        for (int num : nums) {
            sum += num;

            int key = sum - k;

            res += map.getOrDefault(key, 0);
            map.merge(sum, 1, Integer::sum);
        }

        return res;
    }
}
