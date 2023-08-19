// problem link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy = prices[0];
        int sell = 0;
        for(int i = 1 ; i < prices.length ; i++){
            if(prices[i] < buy && i != prices.length-1){
                buy = prices[i];
                sell =0;
            }
            else if( prices[i] > sell ){
                sell = prices[i];
            }
           
            profit = Math.max(profit,sell-buy);
            // System.out.println(buy+" "+sell+" "+profit);
        }
        return profit;
    }
}
