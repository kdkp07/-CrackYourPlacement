problem link  : https://leetcode.com/problems/top-k-frequent-elements/
class Solution {
    class Pair{
        int num;
        int fq;
        Pair(int num,int fq){
            this.num = num;
            this.fq = fq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>( (a,b) -> (b.fq-a.fq) );
        int[] ans = new int[k];
        int max = Integer.MIN_VALUE;
        for(int i : nums) max = Math.max(max,i);
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        int idx = 0;
        for(int i : hm.keySet()){
            pq.add(new Pair(i,hm.get(i)));
        }
        while(k>0){
            Pair p = pq.poll();
            ans[idx++] =p.num;
            k--;
        }
        return ans;
    }
}
