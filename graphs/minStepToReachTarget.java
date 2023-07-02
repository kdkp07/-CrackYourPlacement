class Solution
{
    //Function to find out minimum steps Knight needs to reach target position.
    class Tuple{
        int r;
        int c;
        int steps;
        Tuple(int r , int c, int steps){
            this.r = r; 
            this.c = c;
            this.steps = steps;
        }
    }
    public int minStepToReachTarget(int init[], int tar[], int n)
    {
        // Code here
        Queue<Tuple> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][n];
        int dx[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
        int dy[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
        q.add(new Tuple(init[0]-1,init[1]-1,0));
        int ans = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            Tuple t = q.poll();
            int r = t.r;
            int c = t.c;
            int steps = t.steps;
            if(r == tar[0]-1 && c == tar[1]-1) return steps;
            vis[r][c] = true;
            
            for(int i = 0; i < 8 ; i++){
                int nr = r + dx[i];
                int nc = c + dy[i];
                
                if(nr>=0 && nc>=0 && nr<n && nc<n && !vis[nr][nc]){
                    q.add(new Tuple(nr,nc,steps+1));
                    vis[nr][nc] = true;
                }
            }
        }
        return -1;
    }
}
