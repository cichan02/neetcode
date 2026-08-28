class Solution {
    public int rob(final int[] nums) {
        int zero = 0, first = 0, tmp;
        for (int num: nums) {
            tmp = Math.max(num + zero, first);
            zero = first;
            first = tmp;
        }
        return first;
    }
}
