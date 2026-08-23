class Solution {
    public int climbStairs(int n) {
        int zero = 1, first = 1;
        for (int i = 1; i < n; i++) {
            int tmp = zero + first;
            zero = first;
            first = tmp;
        }
        return first;
    }
}
