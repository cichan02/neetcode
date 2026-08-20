class Solution {
    public int climbStairs(int n) {
        int zero = 1;
        int first = 1;
        for (int i = 2; i < n+1; i++) {
            int tmp = first;
            first += zero;
            zero = tmp;
        }
        return first;
    }
}
