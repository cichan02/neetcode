class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = HashMap.newHashMap(nums.length);
        IntStream.of(nums).forEach(i -> freq.merge(i, 1, Integer::sum));

        List<Integer>[] buckets = new List[nums.length + 1];
        for (int i = 1; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        freq.forEach((key, v) -> buckets[v].add(key));

        int[] res = new int[k--];
        for (int i = buckets.length - 1; i > 0; i--) {
            for (int num: buckets[i]) {
                res[k--] = num;
                if (k < 0) {
                    return res;
                }
            }
        }
        return res;
    }
}
