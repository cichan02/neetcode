public class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0, res = 0;
        HashMap<Integer, Integer> map = HashMap.newHashMap(nums.length);
        map.put(0, 1);

        for (int num : nums) {
            sum += num;

            int key = sum - k;

            res += map.getOrDefault(key, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return res;
    }
}
