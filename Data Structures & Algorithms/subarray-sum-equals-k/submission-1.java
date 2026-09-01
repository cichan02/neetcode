public class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0, amount = 0;
        HashMap<Integer, Integer> map = new HashMap<>(nums.length) {{
            put(0, 1);
        }};

        for (int num : nums) {
            sum += num;
            amount += map.getOrDefault(sum - k, 0);

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return amount;
    }
}
