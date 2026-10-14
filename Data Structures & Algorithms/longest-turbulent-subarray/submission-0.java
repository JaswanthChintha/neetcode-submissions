class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int max=1;
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                if(isTurbulent(arr,i,j)){
                    max=Math.max(max,j-i+1);
                }
            }
        }
        return max;
    }
    public boolean isTurbulent(int[] arr,int i,int j){
        if(i==j) return true;
        boolean greater=arr[i+1]>arr[i];
        boolean smaller=arr[i+1]<arr[i];
        if(!greater && !smaller) return false;
        for(int k=i+2;k<=j;k++){
            if(greater && arr[k]>=arr[k-1]) return false;
            if(smaller && arr[k]<=arr[k-1]) return false;
            boolean temp=greater;
            greater=smaller;
            smaller=temp;
        }
        return true;
    }
}