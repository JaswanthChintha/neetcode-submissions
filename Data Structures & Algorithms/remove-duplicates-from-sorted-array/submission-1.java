class Solution {
    public int removeDuplicates(int[] nums) {
        LinkedHashSet<Integer> set=new LinkedHashSet<>();
        for(int num:nums) set.add(num);
        int k=0;
        for(int x:set){
            nums[k]=x;
            k++;
        }
        return k;
    }
}