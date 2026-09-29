class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]> queue=new LinkedList<>();
        int fresh=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==2)
                {
                    queue.offer(new int[]{i,j});

                }
                if(grid[i][j]==1)
                {
                    fresh+=1;
                }
            }
        }
        int minutes=0;
        int[][] directions={{-1,0},{1,0},{0,-1},{0,1}};
        while(!queue.isEmpty() && fresh>0)
        {
            int size=queue.size();
            for(int i=0;i<size;i++)
            {
                int[] current=queue.poll();
                int r=current[0];
                int c=current[1];
                for(int[] direction:directions)
                {
                    int nr=r+direction[0];
                    int nc=c+direction[1];
                    if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1)
                    {
                        grid[nr][nc]=2;
                        fresh--;
                        queue.offer( new int[]{nr,nc});

                    }
                }
            }
            minutes++;
        }
        if(fresh>0)
        {
            return -1;
        }
        return minutes;
    }
}