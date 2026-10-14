class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] a=s1.toCharArray();
        Arrays.sort(a);
        String sorted1=new String(a);
        int len=s1.length();
        for(int i=0;i<=s2.length()-len;i++){
            String sub=s2.substring(i,i+len);
            char[] b=sub.toCharArray();
            Arrays.sort(b);
            String sorted=new String(b);
            if(sorted1.equals(sorted)) return true;
        }
        return false;
    }
}
