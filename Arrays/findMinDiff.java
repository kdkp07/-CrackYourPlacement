// problem link : https://practice.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1#
class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        // your code here
        long ans = Long.MAX_VALUE;
        Collections.sort(a);
        for(int i =0;i<=n-m;i++){
            ans = Math.min(ans,a.get(i+m-1)-a.get(i));
        }
        return ans;
    }
}
