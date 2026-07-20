class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> uniques = IntStream.of(nums).boxed().collect(Collectors.toSet());
        int res = 0;
        for (int num: nums) {
            if (!uniques.contains(num - 1)) {
                int l = 1;
                while (uniques.contains(num + l)) {
                    l++;
                }
                res = Math.max(res, l);
            }
        }
        return res;
    }
}
