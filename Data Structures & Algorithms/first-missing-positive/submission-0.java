class Solution {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        for(int i=1;i<=n+1;i++){
            boolean found=false;
            for(int j=0;j<n;j++){
                if(nums[j]==i){
                    found=true;
                    break;
                }
            }
            if(!found)return i;
        }
        return n+1;
    }
}