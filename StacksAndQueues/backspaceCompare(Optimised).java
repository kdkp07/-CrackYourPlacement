problem link : https://leetcode.com/problems/backspace-string-compare/
class Solution {
    public boolean backspaceCompare(String s, String t) {
        int s_pointer = s.length()-1 ; 
        int t_pointer = t.length()-1 ;
        int s_skips = 0;
        int t_skips = 0;
        
        while(s_pointer>=0 || t_pointer>=0){
            
            while(s_pointer>=0){
                if(s.charAt(s_pointer) =='#'){
                    s_skips++;
                    s_pointer--;
                }
                else if(s_skips>0){    // skip the character
                    s_skips--;
                    s_pointer--;
                }
                else{
                    break;
                }
            }
            
            while(t_pointer>=0){
                if(t.charAt(t_pointer) =='#'){
                    t_skips++;
                    t_pointer--;
                }
                else if(t_skips>0){    // skip the character
                    t_skips--;
                    t_pointer--;
                }
                else{
                    break;
                }
            }
            
            if( (s_pointer>=0) != (t_pointer>=0) ) return false;
            if(s_pointer>=0 && t_pointer >=0 && s.charAt(s_pointer) != t.charAt(t_pointer)) return false;
            s_pointer--;
            t_pointer--;
        }
        return true;
    }
}
