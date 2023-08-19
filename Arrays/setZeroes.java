// problem link : https://leetcode.com/problems/set-matrix-zeroes/
class Solution {
    public void setZeroes(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        for(int i =0 ; i < m;i++){
            for(int j =0;j<n;j++){
                if(mat[i][j]== 0){
                    row[i] =1;
                    col[j] = 1;
                }
            }
        }
        for(int i =0 ;i<col.length;i++){
            if(col[i]==1){
                for(int j =0;j<m;j++){
                    mat[j][i] = 0;
                }
            }
        }
        
        
        for(int i =0 ;i<row.length;i++){
            if(row[i]==1){
                for(int j =0;j<n;j++)
                {
                    mat[i][j] = 0;
                }
            }
        }
        
    }
}
