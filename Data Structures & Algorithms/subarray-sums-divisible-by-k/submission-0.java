class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int sum = 0, res = 0;
        HashMap<Integer, Integer> prefixSums = HashMap.newHashMap(nums.length);
        prefixSums.put(0, 1);

        for (int num : nums) {
            sum += num;

            int remain = sum % k;
            if (remain < 0) {
                remain += k;
            }

            res += prefixSums.getOrDefault(remain, 0);
            prefixSums.merge(remain, 1, Integer::sum);
        }

        return res;
    }
}