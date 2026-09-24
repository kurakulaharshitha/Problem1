class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n=image.length;
        int m=image[0].length;
        int newcolor=image[sr][sc];
        if(newcolor==color)
        {
            return image;
        }
        return dfs(image,sr,sc,color,newcolor);
        
    }
    private int[][] dfs(int[][] image,int sr,int sc,int color ,int newcolor)
    {
        int n=image.length;
        int m=image[0].length;
        if(sr<0 ||sc<0 || sr>=n ||sc>=m|| image[sr][sc]!=newcolor)
        {
            return image;
        }
        image[sr][sc]=color;

        //recursion in horizontal and vertical directions
        dfs(image,sr,sc-1,color,newcolor);
        dfs(image,sr,sc+1,color,newcolor);
        dfs(image,sr-1,sc,color,newcolor);
        dfs(image,sr+1,sc,color,newcolor);

    
    return image;
}
}