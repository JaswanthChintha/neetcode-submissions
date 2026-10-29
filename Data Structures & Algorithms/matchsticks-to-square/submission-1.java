class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum=0;
        for(int x:matchsticks){
            sum+=x;
        }
        if(sum%4!=0) return false;
        Arrays.sort(matchsticks);
        int target=sum/4;
        int[] sides=new int[4];
        return solve(matchsticks,0,sides,target);
    }
    public boolean solve(int[] arr,int index,int[] sides,int target){
        if(index==arr.length){
            return sides[0]==target && sides[1]==target && sides[2]==target;
        }
        for(int i=0;i<4;i++){
            if(sides[i]+arr[index]<=target){
                sides[i]+=arr[index];
                if(solve(arr,index+1,sides,target)) return true;
                sides[i]-=arr[index];
            }
            
        }
        return false;
    }
}