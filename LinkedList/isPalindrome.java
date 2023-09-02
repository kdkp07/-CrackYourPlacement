// Problem link : https://leetcode.com/problems/palindrome-linked-list/
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
    public ListNode reverse(ListNode head){
        ListNode curr = head , prev = null;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        if(head.next==null) return true;    // single node
        if(head==null) return false;
        ListNode slow = head , fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = reverse(slow);
        ListNode ptr = head;
        
        while(temp!=null){
            if(temp.val!=ptr.val){
                return false;
            }
            ptr =ptr.next;
            temp =temp.next;
        }
        return true;
    }
}
/*

1 2 1 2
s
f
  s 
    f
    
1 2 3 4 5
s
f
  s
    f 
    s
         f
         
1 2
2 1

*/
