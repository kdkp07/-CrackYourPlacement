// problem  link : https://practice.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        // add your code here
       int c_0 = 0 , c_1 = 0 , c_2 = 0;
        while(head!=null){
            if(head.data==0){
                c_0++;
            }
            else if(head.data==1){
                c_1++;
            }
            else{
                c_2++;
            }
            head = head.next;
        }
        // System.out.print(li);
        Node dummy = new Node(-1);
        Node tmp=null;
        if(c_0>0) {
            tmp = new Node(0);
            dummy.next = tmp;
            c_0--;
        }
        else if(c_1>0){
            tmp = new Node(1);
            dummy.next = tmp;
            c_1--;
        }
        else if(c_2>0){
            tmp = new Node(2);
            dummy.next = tmp;
            c_2--;
        }
        
        while(c_0>0){
            tmp.next = new Node(0);
            c_0--;
            tmp = tmp.next;
        }
        while(c_1>0){
            tmp.next = new Node(1);
            c_1--;
            tmp = tmp.next;
        }
        while(c_2>0){
            tmp.next = new Node(2);
            c_2--;
            tmp = tmp.next;
        }
        
        
        return dummy.next;
    }
}
