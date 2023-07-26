// Problem link : https://leetcode.com/problems/range-sum-query-2d-immutable/
class NumMatrix {
    private int[][] dp;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        dp = new int[m+1][n+1];

        for(int i =1;  i <=m ; i++){
            for(int j = 1;j<=n;j++){
                dp[i][j] = matrix[i-1][j-1] +dp[i-1][j] + dp[i][j-1]- dp[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row2++;col1++;row1++;col2++;
        return dp[row2][col2] - dp[row2][col1-1] - dp[row1-1][col2] + dp[row1-1][col1-1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
