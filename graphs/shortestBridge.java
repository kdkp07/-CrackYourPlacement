class Solution {
    class Tuple{
        int r;
        int c;
        int flips;
        Tuple(int r, int c , int flips){
            this.r = r;
            this.c = c;
            this.flips = flips;
        }
    }
    private int n;
    public void dfs(int[][] grid, int[][] vis , int i ,int j, Queue<Tuple> q ){
        if(i>=n || j>=n || i<0 || j<0 || grid[i][j]==0 || vis[i][j]==1) return;
        vis[i][j] = 1;
        q.add(new Tuple(i,j,0));
        dfs(grid,vis,i-1,j,q);
        dfs(grid,vis,i,j+1,q);
        dfs(grid,vis,i+1,j,q);
        dfs(grid,vis,i,j-1,q);
    }
    public int shortestBridge(int[][] grid) {
        n = grid.length;
        int[][] vis = new int[n][n];
        Queue<Tuple> q = new LinkedList<>();
        int flag = 1;
        for(int i =0;i<n;i++){
            for(int j =0 ; j <n ;j++){
                if(flag==1 && grid[i][j]==1){
                    dfs(grid,vis,i,j,q);
                    flag = 0;
                }
            }
            
        }
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
                        // now bfs to get the number of flips
        while(!q.isEmpty()){
            Tuple t = q.poll();
            int row = t.r;
            int col = t.c;
            int flips = t.flips;
            System.out.println(row+" "+col+" "+flips);
            for(int i =0 ;i <4; i++){
                int nr = row+dx[i];
                int nc = col+dy[i];
                if(nr>=0 && nc>=0 && nr<n && nc<n && vis[nr][nc]==0 && grid[nr][nc]==1) return flips;
                else if(nr>=0 && nc>=0 && nr<n && nc<n && vis[nr][nc]!=1 && grid[nr][nc]==0){
                    vis[nr][nc] =1 ; 
                    q.add(new Tuple(nr,nc,flips+1));
                }
            }
            flips++;
        }
        return -1;
    }
}
