// problem link  : https://leetcode.com/problems/next-greater-element-i/
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        HashMap<Integer,Integer> hm = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < nums2.length ; i++){
            // for every number we check its value with top value of stack if its greater then we pop all the elements with value less than this num and mark their next greater element to be this num.
            while(!st.isEmpty() && nums2[i] > st.peek()){
                hm.put(st.pop(),nums2[i]);
            }
            st.push(nums2[i]);
        }
        for(int i = 0 ; i  < nums1.length ; i++){
            ans[i] = hm.getOrDefault(nums1[i],-1);
        }
        return ans;
    }
}
