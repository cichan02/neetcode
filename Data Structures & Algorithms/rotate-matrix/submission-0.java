class Solution {
    private int rows;
    private int cols;

    public void rotate(int[][] m) {
        this.rows = m.length;
        this.cols = m[0].length;

        reverse(m);
        traspose(m);
    }

    private void reverse(int[][] m) {
        for (int i = 0; i < rows / 2; i++) {
            int[] tmp = m[i];
            m[i] = m[rows - 1 - i];
            m[rows - 1 - i] = tmp;
        }
    }

    private void traspose(int[][] m) {
        for (int i = 0; i < rows; i++) {
            for (int j = i; j < cols; j++) {
                int tmp = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = tmp;
            }
        }
    }
}
