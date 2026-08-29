class Solution {
    private int n;

    public void rotate(int[][] m) {
        this.n = m.length;

        reverse(m);
        transpose(m);
    }

    private void reverse(int[][] m) {
        for (int i = 0; i < n/2; i++) {
            int[] tmp = m[i];
            m[i] = m[n - 1 - i];
            m[n - 1 - i] = tmp;
        }
    }

    private void transpose(int[][] m) {
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                m[i][j] ^= m[j][i];
                m[j][i] ^= m[i][j];
                m[i][j] ^= m[j][i];
            }
        }
    }
}
