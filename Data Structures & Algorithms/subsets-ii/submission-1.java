class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> set=new HashSet<>();
        Arrays.sort(nums);
        ArrayList<Integer> current=new ArrayList<>();
        solve(nums,0,current,set);
        return new ArrayList<>(set);
    }
    public void solve(int[] nums,int index,List<Integer> current,Set<List<Integer>> set){
        if(index==nums.length){
            set.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[index]);
        solve(nums,index+1,current,set);
        current.remove(current.size()-1);
        solve(nums,index+1,current,set);
    }
}
