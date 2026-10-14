class Solution {
    public int lastStoneWeight(int[] stones) {
        ArrayList<Integer> list=new ArrayList<>();
        for(int stone:stones){
            list.add(stone);
        }
        while(list.size()>1){
            Collections.sort(list);
            int y=list.remove(list.size()-1);
            int x=list.remove(list.size()-1);
            if(y!=x){
                list.add(y-x);
            }

        }
        if(list.size()==0){
            return 0;
        }
        if(list.size()==0){
            return 0;
        }
        return list.get(0);
    }
}
