// problem link : https://practice.geeksforgeeks.org/problems/prerequisite-tasks/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
class Solution {
    public boolean isPossible(int N,int P, int[][] arr)
    {
        // Your Code goes here
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[N];
        for(int i =0; i < N ;i++){
            adj.add(new ArrayList<>());
        }
        for(int i =0; i < P ; i++){
            adj.get(arr[i][1]).add(arr[i][0]);
            indegree[arr[i][0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        int cnt = 0;
        for(int i = 0; i < N ;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int node = q.poll();
            
            for(var it :adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
            cnt++;
        }
        return cnt==N;   
    }
}
