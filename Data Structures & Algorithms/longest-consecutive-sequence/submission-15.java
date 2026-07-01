class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        int res = 0;
        for (int num: nums) {
            if (!set.contains(num - 1)) {
                int temp = 1;
                while (set.contains(num + temp)) {
                    temp++;
                }
                res = Math.max(res, temp);
            }
        }
        return res;
    }
}
