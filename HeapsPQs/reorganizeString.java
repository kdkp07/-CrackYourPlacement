// problem link  : https://leetcode.com/problems/reorganize-string/
class Solution {
    public String reorganizeString(String s) {
        int len = s.length();

        int[][] freq = new int[26][2];
        for(int i = 0 ; i < freq.length; i++){
            freq[i][1]  = i;
        }
        int max = 0;
        for(int i = 0 ; i < len ; i++){
            char c =s.charAt(i);
            freq[c-'a'][0] += 1;
            max = Math.max(max,freq[c-'a'][0]);
        }
        if(max>(len+1)/2){
            return "";
        }
        Arrays.sort(freq,(a,b)-> (b[0]-a[0]) );
        char[] arr = new char[len];
        int j = 0;
        for(int i = 0 ; i < 26 ; i++){
            for(int k = 0 ; k < freq[i][0] ;k++){
                if(j>=len) j = 1;
                arr[j] = (char)(freq[i][1]+'a'); 
                j+=2;
            }
        }
        return new String(arr);
    }
}
