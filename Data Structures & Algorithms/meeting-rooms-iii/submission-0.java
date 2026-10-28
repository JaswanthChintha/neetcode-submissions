class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->a[0]-b[0]);
        long[] endTime=new long[n];
        int[] count=new int[n];
        for(int i=0;i<meetings.length;i++){
            int start=meetings[i][0];
            int end=meetings[i][1];
            int duration=end-start;
            int room=-1;
            for(int j=0;j<n;j++){
                if(endTime[j]<=start){
                    room=j;
                    break;
                }
            }
            if(room!=-1){
                endTime[room]=end;
                count[room]++;
            }else{
                room=0;
                for(int j=1;j<n;j++){
                    if(endTime[j]<endTime[room]){
                        room=j;
                    }
                }
                endTime[room]+=duration;
                count[room]++;
            }
        }
        int answer=0;
        for(int i=1;i<n;i++){
            if(count[i]>count[answer]){
                answer=i;
            }
        }
        return answer;
    }
}