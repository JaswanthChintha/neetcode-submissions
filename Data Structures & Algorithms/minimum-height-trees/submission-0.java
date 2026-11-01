class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans=new ArrayList<>();
        if(n==1){
            ans.add(0);
            return ans;
        }
        List<List<Integer>> adj=new LinkedList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());

        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] degree=new int[n];
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            degree[i]=adj.get(i).size();
            if(degree[i]==1){
                q.add(i);
            }
        }
        int remaining=n;
        while(remaining>2){
            int size=q.size();
            remaining-=size;
            for(int i=0;i<size;i++){
                int node=q.poll();
                for(int nei:adj.get(node)){
                    degree[nei]--;
                    if(degree[nei]==1){
                        q.add(nei);
                    }
                }
            }
        }
        while(!q.isEmpty()){
            ans.add(q.poll());
        }
        return ans;

    }
}