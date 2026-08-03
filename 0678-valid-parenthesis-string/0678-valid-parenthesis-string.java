class Solution {
    public boolean checkValidString(String s) {
        int l=0;
        int r=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                l++;
                r++;
            }else if(s.charAt(i)==')'){
                l--;
                r--;
            }else{
                l--;
                r++;
            }
            if(r<0) return false;
            if(l<0) l=0;
        }
        return l==0;
    }
}