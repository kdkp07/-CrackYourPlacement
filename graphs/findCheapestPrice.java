// Problem link : https://leetcode.com/problems/cheapest-flights-within-k-stops/
class Tuple{
    int node;
    int price;
    int stops;
    Tuple(int node,int price,int stops){
        this.node = node;
        this.price = price;
        this.stops = stops;
    }
    Tuple(int node,int price){
        this.node = node;
        this.price = price;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Tuple>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < flights.length;i++){
            adj.get(flights[i][0]).add(new Tuple(flights[i][1],flights[i][2]));
        }
        Queue<Tuple> pq = new LinkedList<>();
        pq.add(new Tuple(src,0,0));
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;
        while(!pq.isEmpty()){
            Tuple t = pq.poll();
            int stops = t.stops;
            int node = t.node;
            int p = t.price;
            if(stops>k) continue;
            for(var it : adj.get(node)){
                int adjNode = it.node;
                int price = it.price;
                if(dist[adjNode] > price+p && stops<=k){
                    dist[adjNode] = price+p;
                    pq.add(new Tuple(adjNode,price+p,stops+1));
                }
                
            }
            
        }
        if(dist[dst]!=Integer.MAX_VALUE){
            return dist[dst];
        }
        return -1;
    }
}
