class Solution {
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private int rows;
    private int cols;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        rows = grid.length;
        cols = grid[0].length;
        int nIslands = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    nIslands++;
                    dfs(grid, i, j);
                }
            }
        }
        return nIslands;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        for (int[] dir: DIRECTIONS) {
            dfs(grid, i + dir[0], j + dir[1]);
        }
    }
}
