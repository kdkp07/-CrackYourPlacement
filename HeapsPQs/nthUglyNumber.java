// Problem link : https://leetcode.com/problems/ugly-number-ii/
class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add(1l);
        for(int i = 1 ;i < n;i++){
            long val = pq.poll();
            while(!pq.isEmpty() && val==pq.peek() ) val = pq.poll();
            pq.add(val*2);
            pq.add(val*3);
            pq.add(val*5);
        }
        return pq.poll().intValue();
    }
}
