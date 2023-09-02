//Problem link : https://leetcode.com/problems/remove-linked-list-elements/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        
        ListNode dum = new ListNode(-1);
        dum.next = head;
        ListNode curr = head , prev = dum;
        
        while(curr!=null){
            if(curr.val == val){
                prev.next = curr.next;
                curr = curr.next;
            }
            else{
                prev = prev.next;
                curr = curr.next;
            }
        }
        return dum.next;
    }
}

// 5 -> 6
// p    c
          
