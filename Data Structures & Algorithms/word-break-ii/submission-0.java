class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result=new ArrayList<>();
        solve(s,0,wordDict,"",result);
        return result;
    }
    public void solve(String s,int index,List<String> wordDict,String sentence,List<String> result){
        if(index==s.length()){
            result.add(sentence.trim());
            return;
        }
        for(int i=index+1;i<=s.length();i++){
            String word=s.substring(index,i);
            if(wordDict.contains(word)){
                solve(s,i,wordDict,sentence+word+" ",result);
            }
        }
    }
}