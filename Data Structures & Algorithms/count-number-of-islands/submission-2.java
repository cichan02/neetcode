class Solution {
    private static final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private int rows;
    private int cols;

    public int numIslands(char[][] grid) {
        this.rows = grid.length;
        this.cols = grid[0].length;

        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        for (int[] dir: dirs) {
            dfs(grid, i + dir[0], j + dir[1]);
        }
     }
}
