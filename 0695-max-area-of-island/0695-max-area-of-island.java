class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int max_area=0;
        for(int r=0;r<n;r++)
        {
            for(int c=0;c<m;c++)
            {
                if(grid[r][c]==1)
                {
                    
                    //check for adjacanet hor&ver
                    int area=dfs(grid,r,c);
                    max_area=Math.max(max_area,area);
                }
            }
        }
        return max_area;
        
    }
    private int dfs(int[][] grid,int r ,int c)
    {
         int n=grid.length;
        int m=grid[0].length;
        if(r<0 || r>=n|| c<0|| c>=m)
        {
            return 0;
        }
        if(grid[r][c]==0)
        {
            return 0;
        }
        grid[r][c]=0;
        return 1
    + dfs(grid, r - 1, c)
    + dfs(grid, r + 1, c)
    + dfs(grid, r, c - 1)
    + dfs(grid, r, c + 1);
    }

        
    
}