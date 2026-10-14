class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result=new ArrayList<>();
        find(nums,target,0,new ArrayList<>(),result);
        return result;
    }
    public void find(int[] nums,int target,int index,ArrayList<Integer> current,List<List<Integer>> result){
        if(target==0){
            result.add(new ArrayList<>(current));
            return;
        }
        if(target<0 || index==nums.length){
            return;
        }
        current.add(nums[index]);
        find(nums,target-nums[index],index,current,result);
        current.remove(current.size()-1);
        find(nums,target,index+1,current,result);
    }
}
