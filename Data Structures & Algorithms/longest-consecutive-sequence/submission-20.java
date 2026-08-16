class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> uniques = Arrays.stream(nums)
            .boxed()
            .collect(Collectors.toSet());
        int maxL = 0;
        for (int num: nums) {
            if (!uniques.contains(num - 1)) {
                int l = 1;
                while (uniques.contains(num + l)) {
                    l++;
                }
                maxL = Math.max(maxL, l);
            }
        }
        return maxL;
    }
}
