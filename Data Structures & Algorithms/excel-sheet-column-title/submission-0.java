class Solution {
    public String convertToTitle(int columnNumber) {
        String result="";
        while(columnNumber>0){
            columnNumber--;
            char ch=(char)('A'+(columnNumber%26));
            result=ch+result;
            columnNumber=columnNumber/26;
        }
        return result;
    }
}