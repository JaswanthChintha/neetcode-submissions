class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        for(int i=0;i<words.length-1;i++){
            String word1=words[i];
            String word2=words[i+1];
            int j=0;
            while(j<word1.length() && j<word2.length() && word1.charAt(j)==word2.charAt(j)){
                j++;
            }
            if(j==word2.length() && j<word1.length()){
                return false;
            }
            if(j<word1.length() && j<word2.length()){
                int x=order.indexOf(word1.charAt(j));
                int y=order.indexOf(word2.charAt(j));
                if(x>y) return false;
            }
        }
        return true;
    }
}
