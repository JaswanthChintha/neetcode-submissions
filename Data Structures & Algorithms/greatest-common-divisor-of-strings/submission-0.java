class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String ans="";
        int min=Math.min(str1.length(),str2.length());
        for(int i=1;i<=min;i++){
            String s=str1.substring(0,i);
            if(canDivide(str1,s) && canDivide(str2,s)){
                ans=s;
            }
        }
        return ans;
    }
    public boolean canDivide(String str,String s){
        if(str.length()%s.length()!=0) return false;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!=s.charAt(i%s.length())){
                return false;
            }
        }
        return true;
    }
}