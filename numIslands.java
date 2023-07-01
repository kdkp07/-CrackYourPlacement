class Solution {
    
    public void dfs(char[][] vis,char[][] grid, int i , int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]=='0' || vis[i][j]=='1') return;
        vis[i][j] = '1';
        dfs(vis,grid,i+1,j);
        dfs(vis,grid,i-1,j);
        dfs(vis,grid,i,j+1);
        dfs(vis,grid,i,j-1);
        
    }
    public int numIslands(char[][] grid) {
        int count = 0;
        char[][] vis = new char[grid.length][grid[0].length];
        for(int i =0 ; i < grid.length ; i++){
            for(int j =0 ; j < grid[0].length;j++){
                vis[i][j] = '0';
            }
        }
        
        for(int i =0 ; i < grid.length ; i++){
            for(int j =0;j<grid[0].length ; j++){
                if(grid[i][j]=='1' && vis[i][j]=='0'){
                    dfs(vis,grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
}
