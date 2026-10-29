class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        boolean[] used=new boolean[profits.length];
        for(int i=0;i<k;i++){
            int maxProfit=0;
            int index=-1;
            for(int j=0;j<profits.length;j++){
                if(!used[j] && capital[j]<=w){
                    if(profits[j]>maxProfit){
                        maxProfit=profits[j];
                        index=j;
                    }
                }
            }
            if(index==-1) break;
            w+=profits[index];
            used[index]=true;
        }
        return w;
    }
}