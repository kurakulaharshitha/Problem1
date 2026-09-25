class Solution {
    public int closedIsland(int[][] grid) {
         int n=grid.length;
        int m=grid[0].length;
        int closedisland=0;
        for(int r=0;r<n;r++)
        {
            for(int c=0;c<m;c++)
            {
                if(grid[r][c]==0)
                {
                    if(dfs(grid,r,c))
                    closedisland++;
                }
            }
        }
        return closedisland;
        
    }
    private boolean dfs(int[][] grid,int r,int c)
    {
        int n=grid.length;
        int m=grid[0].length;
        if(r<0 ||  r>=n || c<0 || c>=m)
        {
            return false;
        }
        if(grid[r][c]==1)
        {
            return true;
        }
        grid[r][c]=1;
        boolean up=dfs(grid,r-1,c);
        boolean down = dfs(grid, r + 1, c);
        boolean left = dfs(grid, r, c - 1);
        boolean right = dfs(grid, r, c + 1);

        return up&& down&& left && right;

    }
}