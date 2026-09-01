class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int res = 0, sum = 0;
        // HashMap<Integer, Integer> prefix = HashMap.newHashMap(nums.length);
        // prefix.put(0, 1);
        int[] prefix = new int[k];
        prefix[0] = 1;

        for (int num: nums) {
            sum += num;

            int key = sum % k;
            if (key < 0) {
                key += k;
            }

            res += prefix[key];
            prefix[key] += 1;
            // prefix.merge(key, 1, Integer::sum);
        }
        return res;
    }
}