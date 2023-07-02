class Solution {
    public static void helper(int[][] grid, int n, List<String> ans, int i , int j,StringBuilder sb,boolean[][] vis){
        if(i==n-1 && j == n-1){
            ans.add(sb.toString());
            return;
        }
        vis[i][j] = true;
        if(j+1<n && grid[i][j+1]==1 && !vis[i][j+1]){
            sb.append("R");
            helper(grid,n,ans,i,j+1,sb,vis);
            sb.deleteCharAt(sb.length()-1);
        }
        if(i+1<n && grid[i+1][j]==1 && !vis[i+1][j]){
            sb.append("D");
            helper(grid,n,ans,i+1,j,sb,vis);
            sb.deleteCharAt(sb.length()-1);
        }
        if(j>0 && grid[i][j-1]==1 && !vis[i][j-1]){
            sb.append("L");
            helper(grid,n,ans,i,j-1,sb,vis);
            sb.deleteCharAt(sb.length()-1);
        }
        if(i>0 && grid[i-1][j]==1 && !vis[i-1][j]){
            sb.append("U");
            helper(grid,n,ans,i-1,j,sb,vis);
            sb.deleteCharAt(sb.length()-1);
        }
        vis[i][j] = false;              // unvisiting cells for another potential paths
    }
    public static ArrayList<String> findPath(int[][] grid, int n) {
        // Your code here
        ArrayList<String> ans = new ArrayList<>();
        if(grid[0][0]==0) return ans;
        boolean[][] vis = new boolean[n][n];
        helper(grid,n,ans,0,0,new StringBuilder(),vis);
        return ans;
    }
}
