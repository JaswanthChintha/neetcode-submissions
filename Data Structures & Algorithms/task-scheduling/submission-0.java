class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        int[] last=new int[26];
        Arrays.fill(last,-n-1);
        for(char c:tasks){
            freq[c-'A']++;
        }
        int time=0;
        int completed=0;
        while(completed<tasks.length){
            int index=-1;
            int max=0;
            for(int i=0;i<26;i++){
                if(freq[i]>0 && time-last[i]>n && freq[i]>max){
                    max=freq[i];
                    index=i;
                }
            }
            if(index!=-1){
                freq[index]--;
                last[index]=time;
                completed++;
            }
            time++;
        }
        return time;
    }
}
