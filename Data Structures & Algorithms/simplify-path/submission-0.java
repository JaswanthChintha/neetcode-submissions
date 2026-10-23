class Solution {
    public String simplifyPath(String path) {
        Stack<String> st=new Stack<>();
        String[] parts=path.split("/");
        for(String part:parts){
            if(part.equals("") || part.equals(".")) continue;
            else if(part.equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }

            }else{
                st.push(part);
            }
        }
        String result="";
        for(String sir:st){
            result+="/"+sir;
        }
        if(result.equals("")) return "/";
        return result;
    }
}