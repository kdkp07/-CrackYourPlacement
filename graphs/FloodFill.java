class Solution {
    private int m;
    private int n;
    public void dfs(int[][] image ,int i , int j , int color,int original){
        if(i>=m || j>=n || i<0 || j<0 || image[i][j]!=original) return;
        image[i][j] = color;
    
        dfs(image,i-1,j,color,original);
        dfs(image,i,j+1,color,original);
        dfs(image,i+1,j,color,original);
        dfs(image,i,j-1,color,original);
        
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        m = image.length;
        n = image[0].length;
        if(image[sr][sc]==color) return image;
        int original = image[sr][sc];
        dfs(image,sr,sc,color,original);
        return image;
    }
}
