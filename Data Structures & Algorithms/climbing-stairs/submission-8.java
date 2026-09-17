class Solution {
    public int climbStairs(int n) {
        int zero = 1, prim = 1;
        for (int i = 1; i < n; i++) {
            int tmp = prim;
            prim += zero;
            zero = tmp;
        }
        return prim;
    }
}
