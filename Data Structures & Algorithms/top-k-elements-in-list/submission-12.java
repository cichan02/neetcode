class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = HashMap.newHashMap(nums.length);
        IntStream.of(nums).forEach(i -> freq.merge(i, 1, Integer::sum));

        Comparator<Pair<Integer, Integer>> c = Comparator.comparingInt(Pair::right);
        PriorityQueue<Pair<Integer, Integer>> pairs = new PriorityQueue<>(c.reversed());
        freq.forEach((key, value) -> pairs.offer(Pair.of(key, value)));

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pairs.poll().left();
        }
        return res;
    }
}

record Pair<L, R> (L left, R right) {
    public static <L, R> Pair<L, R> of(L left, R right) {
        return new Pair<>(left, right);
    }
}
