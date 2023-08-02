// problem link : https://leetcode.com/problems/backspace-string-compare/
class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        int l1 = s.length();
        int l2 = t.length();
        for(int i = 0 ; i < l1 ; i++){
            if(s1.size()!=0 && s.charAt(i)=='#'){
                s1.pop();
            }
            else if (s.charAt(i)!='#'){
                s1.push(s.charAt(i));
            } 
        }
        for(int i = 0 ; i < l2 ; i++){
            if(s2.size()!=0 && t.charAt(i)=='#'){
                s2.pop();
            }
            else if(t.charAt(i)!='#'){
                s2.push(t.charAt(i));
            }
            
        }
       
        if(s1.size()!=s2.size()) return false;
        while(!s1.isEmpty() && !s2.isEmpty()){
            if(s1.pop()!=s2.pop()) return false;
        }
        return true;
    }
}
