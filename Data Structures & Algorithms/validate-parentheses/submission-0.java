class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        HashMap<Character,Character> map=new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        for(char ch:s.toCharArray()){
            if(ch=='(' || ch=='{' || ch=='['){
                st.push(ch);
            }
            else{
                if(st.isEmpty() || st.pop()!=map.get(ch)){
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}
