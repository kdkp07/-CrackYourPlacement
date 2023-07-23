// Problem link : https://practice.geeksforgeeks.org/problems/predecessor-and-successor/1
public static void findPreSuc(Node root, int key)
    {
        // code here.
        
        /* There are two static nodes defined above pre(representing predecessor) and suc(representing successor) as follows:
           static Node pre=null,suc=null
           You need to update these both.
           And the data inside these classes will be printed automatically by the driver code. 
        */
        if(root==null)return;
        
        if(root.data > key){
            if(suc==null){
                suc = root;
            }
            else if(suc!=null && suc.data > root.data){
                suc = root;
            }
            else if(suc.data < root.data){
                // do nothing;
            }
        }
        if(root.data<key){
            if(pre==null){
                pre = root;
            }
            else if(pre!=null && pre.data < root.data){
                pre = root;
            }
            else if(pre.data > root.data){
                // do nothing;
            }
            
        }
        findPreSuc(root.left,key);
        findPreSuc(root.right,key);
        
    }
}
