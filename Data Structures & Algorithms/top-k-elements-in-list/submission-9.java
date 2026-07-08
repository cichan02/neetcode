class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List[] buckets = new List[nums.length + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            buckets[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k--];
        for (int i = buckets.length - 1; i >= 0; i--) {
            List<Integer> freq = buckets[i];
            if (freq.isEmpty()) {
                continue;
            }

            for (int num: freq) {
                res[k--] = num;
                if (k < 0) {
                    return res;
                }
            }
        }

        return new int[]{0,1};
    }
}
