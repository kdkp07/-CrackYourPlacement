// problem link : https://leetcode.com/problems/snakes-and-ladders/
class Solution {
    public int[] findCoordinates(int curr , int n){
        int r = n - ( curr - 1) / n - 1;
        int c = (curr -1) %n;
        if(n%2 == r%2){
            return new int[]{r,n-1-c};
        }
        return new int[]{r,c};
    }
    public int snakesAndLadders(int[][] mat) {
        int n = mat.length;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        boolean[][] vis = new boolean[n][n];
        vis[n-1][0] = true;
        int steps = 0;
        while(!q.isEmpty()){
            
            int size = q.size();
            for(int i =0; i< size;i++){
                int curr = q.poll();                
                if(curr==n*n) return steps;
                for(int j = 1 ; j<=6;j++){
                    if(curr+j>n*n) break;
                    int[] pos = findCoordinates(curr+j,n);
                    int row = pos[0];
                    int col = pos[1];
                    if(vis[row][col]==true) continue;
                    vis[row][col] = true;
                        if(mat[row][col]==-1){
                            q.add(curr+j);
                        }
                        else{
                            q.add(mat[row][col]);
                        }
                }
            }
            steps++;
        }
        return -1;
    }
}
