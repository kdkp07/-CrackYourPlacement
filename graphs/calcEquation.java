// Problem link : https://leetcode.com/problems/evaluate-division/
class Solution {
    public double helper(String start , String end , Map<String,Map<String,Double>> adj,HashSet<String> visited){
        if(!adj.containsKey(start))
            return -1.0;
        if(adj.get(start).containsKey(end))         // if found the edge then return the value against the key
            return adj.get(start).get(end);
        visited.add(start);
        for(Map.Entry<String,Double> entry : adj.get(start).entrySet()){
            if(!visited.contains(entry.getKey())){
                double prod = helper(entry.getKey(),end,adj,visited);
                if(prod != -1.0)
                    return prod * entry.getValue();
            }
        }
        return -1.0;
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> q)         {   
        double[] ans = new double[q.size()];
        int n = equations.size();
        Map<String,Map<String,Double>> adj = new HashMap<>();
        for(int j = 0; j < n ; j++){
            String u = equations.get(j).get(0);
            String v = equations.get(j).get(1);
            
            adj.putIfAbsent(u,new HashMap<>());
            adj.get(u).put(v,values[j]);
            adj.putIfAbsent(v,new HashMap<>());
            adj.get(v).put(u,1/values[j]);
        }
        
        for(int i = 0; i < q.size() ;i++){
            ans[i] = helper(q.get(i).get(0),q.get(i).get(1),adj,new HashSet<>());
        }
        return ans;
    }
}
