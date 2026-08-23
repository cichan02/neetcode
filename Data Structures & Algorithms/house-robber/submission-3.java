class Solution {
    public int rob(int[] nums) {
        int zero = 0, first = 0;
        for (int num: nums) {
            int tmp = Math.max(num + zero, first);
            zero = first;
            first = tmp;
        }
        return first;
    }
}
