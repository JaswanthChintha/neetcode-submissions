class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min=nums.length+1;
        for(int i=0;i<nums.length;i++){
            int sum=0;
            for(int j=i;j<nums.length;j++){
                sum+=nums[j];
                if(sum>=target){
                    min=Math.min(min,j-i+1);
                    break;
                }
            }
        }
        if(min==nums.length+1){
            return 0;
        }
        return min;
    }
}