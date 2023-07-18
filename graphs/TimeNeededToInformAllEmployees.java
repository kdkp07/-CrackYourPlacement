// problem link : https://leetcode.com/problems/time-needed-to-inform-all-employees/
class Solution {

    public int numOfMinutes(int n, int head, int[] manager, int[] time) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0; i< n ;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0 ; i < n;i++)
        {
            if(manager[i]!=-1){
                adj.get(i).add(manager[i]);
                adj.get(manager[i]).add(i);
            }
        }
        int[] vis = new int[n];
        int ans = 0 ;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(head,0));
        vis[head]=1;
        int max_time = Integer.MIN_VALUE;
        int t =0;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int node = p.node;
            t = p.time;
            ans = Math.max(ans,t);
            for(int it : adj.get(node))
            {
                if(vis[it] == 0)
                {
                    vis[it] =1; 
                    q.add(new Pair(it,t+time[node]));   
                }
            }
        }
        return ans;
    }
}

class Pair{
    int node;
    int time;
    Pair(int node ,int time){
        this.node= node;
        this.time = time;
    }
}
