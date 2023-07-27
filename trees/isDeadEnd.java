// problem link : https://practice.geeksforgeeks.org/problems/check-whether-bst-contains-dead-end/1
/*class Node {
        int data;
        Node left, right;
 
        Node(int item) {
            data = item;
            left = right = null;
        }
    }*/

//Function should return true if a deadEnd is found in the bst otherwise return false.
class GFG
{
    // maintaining upper and lower bound for every node
    // if we can find a value where this bounds become equal we return true for that subtree.
    public static boolean helper(Node root ,int min,int max){
        if(root==null) return false;
        if(min == max) return true;
        if(helper(root.left,min,root.data-1)) return true;
        if(helper(root.right,root.data+1,max)) return true;
        return false;
    }
    public static boolean isDeadEnd(Node root)
    {
        return helper(root,1,Integer.MAX_VALUE);
    }
}
