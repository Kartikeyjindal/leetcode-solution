class Solution 
{
    public int[][] floodFill(int[][] image, int sr, int sc, int color) 
    {
        int originalcolor=image[sr][sc];
        if(image[sr][sc] == color)
        {
            return image;
        }
        dfs(image,sr,sc,color,originalcolor);
        return image;
    }

    public void dfs(int [][]image,int sr,int sc,int color,int originalcolor)
    {
        if(sr >= image.length || sr<0||sc>=image[0].length||sc<0||image[sr][sc]!=originalcolor)
        {
            return;
        }
        if(image[sr][sc] == originalcolor)
        {
            image[sr][sc]=color;
        }

        dfs(image, sr-1, sc, color, originalcolor);
        dfs(image, sr, sc+1, color, originalcolor);
        dfs(image, sr+1, sc, color, originalcolor);
        dfs(image, sr, sc-1, color, originalcolor);
    }
}