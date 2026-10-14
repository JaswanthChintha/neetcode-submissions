class MinStack {
    ArrayList<Integer> list;

    public MinStack() {
        list=new ArrayList<>();
    }
    
    public void push(int val) {
        list.add(val);
    }
    
    public void pop() {
        list.remove(list.size()-1);
    }
    
    public int top() {
        return list.get(list.size()-1);
    }
    
    public int getMin() {
        int min=list.get(0);
        for(int i=1;i<list.size();i++){
            if(list.get(i)<min){
                min=list.get(i);
            }
        }
        return min;
    }
}
