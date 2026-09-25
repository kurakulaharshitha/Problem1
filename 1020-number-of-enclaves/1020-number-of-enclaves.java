class Solution {
    public int numEnclaves(int[][] grid) {
        
     int n=grid.length;
        int m=grid[0].length;
        int count=0;
        for(int r=0;r<n;r++)
        {
            if(grid[r][0]==1)
            dfs(grid,r,0);
            if(grid[r][m-1]==1)
            dfs(grid,r,m-1);
        }
         // Check first and last row
        for (int c = 0; c < m; c++) {

            if (grid[0][c] == 1) {
                dfs(grid, 0, c);
            }

            if (grid[n - 1][c] == 1) {
                dfs(grid, n - 1, c);
            }
        }
        for(int r=0;r<n;r++)
        {
            for(int c=0;c<m;c++)
            {
                if(grid[r][c]==1)
                {
                    count++;
                }
            }
        }
        return count;
        
    }
    private void dfs(int[][] grid,int r,int c)
    {
        int n=grid.length;
        int m=grid[0].length;
        if(r<0 ||  r>=n || c<0 || c>=m)
        {
            return ;
        }
        if(grid[r][c]==0)
        {
            return ;
        }
        
        grid[r][c] = 0;

        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);

    }
}