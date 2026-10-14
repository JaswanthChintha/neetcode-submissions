class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        int[][] result=new int[n+1][2];
        int i=0;
        int k=0;
        while(i<n && intervals[i][1]<newInterval[0]){
            result[k++]=intervals[i++];
        }
        while(i<n && intervals[i][0]<=newInterval[1]){
            newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
            newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        result[k++]=newInterval;
        while(i<n){
            result[k++]=intervals[i++];
        }
        int[][] answer=new int[k][2];
        for(int j=0;j<k;j++){
            answer[j]=result[j];
        }
        return answer;
    }
}
