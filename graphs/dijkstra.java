// Problem link : https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
class Pair{
    int dist;
    int node;
    Pair(int dist, int node){
        this.dist = dist;
        this.node = node;
    }
}
class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>( (x,y) -> x.dist-y.dist);
        pq.add(new Pair(0,S));
        int[] ans = new int[V];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[S] = 0;
        while(pq.size()!=0){
            Pair p = pq.poll();
            int d = p.dist;
            int node = p.node;
            for(List<Integer> it : adj.get(node)){
                int edW = it.get(1);
                int adjNode = it.get(0);
                if(ans[adjNode] > edW+d){
                    ans[adjNode] = edW +d;
                    pq.add(new Pair(ans[adjNode],adjNode));
                }
            }
        }
        return ans;
    }
}

