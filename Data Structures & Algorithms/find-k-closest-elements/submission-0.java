class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result=new ArrayList<>();
        boolean[] used=new boolean[arr.length];
        for(int i=0;i<k;i++){
            int minDistance=Integer.MAX_VALUE;
            int index=-1;
            for(int j=0;j<arr.length;j++){
                if(!used[j]){
                    int dist=Math.abs(arr[j]-x);
                    if(dist<minDistance){
                        minDistance=dist;
                        index=j;
                    }
                }
            }
            result.add(arr[index]);
            used[index]=true;
        }
        Collections.sort(result);
        return result;
    }
}