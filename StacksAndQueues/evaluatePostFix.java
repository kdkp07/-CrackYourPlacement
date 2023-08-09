// problem link : https://practice.geeksforgeeks.org/problems/evaluation-of-postfix-expression1735/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S)
    {
        // Your code here
        Stack<Integer> st = new Stack<>();
        int len = S.length();
        
        for(int i =0 ; i < len ; i++){
            if(S.charAt(i)>='0' && S.charAt(i)<='9' ){
                st.push(( S.charAt(i)-'0' ) );
            }
            else if(S.charAt(i)=='*'){
                int first = st.pop();
                int second = st.pop();
                st.push((first*second) );
            }
            else if(S.charAt(i)=='+'){
                int first = st.pop();
                int second = st.pop();
                st.push( ( first+second) );
            }
            else if(S.charAt(i)=='-'){
                int first = st.pop();
                int second = st.pop();
                st.push((second-first) );
            }
            else if(S.charAt(i)=='/'){
                int first = st.pop();
                int second = st.pop();
                st.push(( second/first) );
            }
            
        }
        return st.pop();
    }
}
