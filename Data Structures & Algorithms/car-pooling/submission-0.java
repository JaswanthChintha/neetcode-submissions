class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int maxLocation=0;
        for(int i=0;i<trips.length;i++){
            maxLocation=Math.max(maxLocation,trips[i][2]);
        }
        for(int location=0;location<=maxLocation;location++){
            int passengers=0;
            for(int i=0;i<trips.length;i++){
                if(trips[i][1]<=location && location<trips[i][2]){
                    passengers+=trips[i][0];
                }
            }
            if(passengers>capacity){
                return false;
            }
        }
        return true;
    }
}