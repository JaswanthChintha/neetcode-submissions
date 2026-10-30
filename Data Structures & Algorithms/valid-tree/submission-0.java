class Solution {
    public boolean validTree(int n, int[][] edges) {
         if(edges.length!=n-1) return false;
         ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
         for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
         }
         for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
         }
         boolean[] visited=new boolean[n];
         dfs(0,adj,visited);
         for(int i=0;i<n;i++){
            if(!visited[i]) return false;
         }
         return true;
    }
    public void dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[] visited){
        visited[node]=true;
        for(int nei:adj.get(node)){
            if(!visited[nei]){
                dfs(nei,adj,visited);
            }
        }
    }
}
