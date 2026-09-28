class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int n=maze.length;
        int m=maze[0].length;
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{entrance[0],entrance[1]});
        maze[entrance[0]][entrance[1]]='+';
        int steps=0;
        int[][] directions=
        {
            {-1,0},{1,0},{0,-1},{0,1}
        };
        while(!queue.isEmpty())
        {
            int size=queue.size();
            steps++;
            for(int i=0;i<size;i++)
            {
                int[] current=queue.poll();
                int r=current[0];
                int c=current[1];
                for(int[] dir:directions)
                {
                    int nr=r+dir[0];
                    int nc=c+dir[1];
                    if(nr<0 || nr>=n || nc<0 || nc>=m)
                    {
                        continue;
                    }
                    if(maze[nr][nc]=='+')
                    {
                        continue;
                    }
                    if(nr==0 ||nr==n-1 ||nc==0 ||nc==m-1)
                    {
                        return steps;
                    }
                    maze[nr][nc]='+';
                    queue.add(new int[]{nr,nc});

                }
            }
        }
        return -1;

        
    }
}