class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=0;j<n;j++){
                sum+=nums[(i+j)%n];
                max=Math.max(max,sum);
            }
        }
        return max;
    }
}