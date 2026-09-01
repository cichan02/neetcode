class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int sum = 0, res = 0;
        HashMap<Integer, Integer> prefixSums = HashMap.newHashMap(nums.length);
        prefixSums.put(0, 1);

        for (int num : nums) {
            sum += num;

            int key = sum % k;
            if (key < 0) {
                key += k;
            }
            
            res += prefixSums.getOrDefault(key, 0);
            prefixSums.merge(key, 1, Integer::sum);
        }

        return res;
    }
}