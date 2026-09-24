class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        for(int r=0;r<n;r++)
        {
            for(int c=0;c<m;c++)
            {
                if(grid[r][c]=='1')
                {
                    count++;
                    //check for adjacanet hor&ver
                    dfs(grid,r,c);
                }
            }
        }
        return count;
        
    }
    private void dfs(char[][] grid,int r ,int c)
    {
         int n=grid.length;
        int m=grid[0].length;
        if(r<0 || r>=n|| c<0|| c>=m)
        {
            return;
        }
        if(grid[r][c]=='0')
        {
            return;
        }
        grid[r][c]='0';
        // Up
        dfs(grid, r - 1, c);

        // Down
        dfs(grid, r + 1, c);

        // Left
        dfs(grid, r, c - 1);

        // Right
        dfs(grid, r, c + 1);
    }

}