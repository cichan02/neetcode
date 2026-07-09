class Solution {
    public int climbStairs(int n) {
        int zero = 1, first = 1;
        for (int i = 2; i < n + 1; i++) {
            int temp = first;
            first = first + zero;
            zero = temp;
        }
        return first;
    }
}
