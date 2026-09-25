class Solution:
    def islandPerimeter(self, grid: list[list[int]]) -> int:
        n=len(grid)
        m=len(grid[0])
        count=0
        for i in range(n):
            for j in range(m):
                if grid[i][j]==1:
                    if i==0 or grid[i-1][j]==0:
                        count=count+1
                    if i==n-1 or grid[i+1][j]==0:
                        count=count+1
                    if j==0 or grid[i][j-1]==0:
                        count=count+1
                    if j==m-1 or grid[i][j+1]==0:
                        count=count+1
        return count
        