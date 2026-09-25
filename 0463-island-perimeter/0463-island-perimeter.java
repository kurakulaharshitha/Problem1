class Solution {
    public int islandPerimeter(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int perim = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1) {
                    perim += dfs(grid, i, j);
                }
            }
        }

        return perim;
    }

    private int dfs(int[][] grid, int r, int c) {

        int n = grid.length;
        int m = grid[0].length;

        // Out of bounds
        if (r < 0 || r >= n || c < 0 || c >= m) {
            return 1;
        }

        // Water
        if (grid[r][c] == 0) {
            return 1;
        }

        // Already visited
        if (grid[r][c] == -1) {
            return 0;
        }

        // Mark as visited
        grid[r][c] = -1;

        // Add perimeter from all 4 directions
        return dfs(grid, r - 1, c)
             + dfs(grid, r + 1, c)
             + dfs(grid, r, c - 1)
             + dfs(grid, r, c + 1);
    }
}