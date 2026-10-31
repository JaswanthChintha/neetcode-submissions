class Solution {
    public int countComponents(int n, int[][] edges) {
         List<List<Integer>> adj=new ArrayList<>();
         for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
         }
         for(int[] a:edges){
            adj.get(a[0]).add(a[1]);
            adj.get(a[1]).add(a[0]);
         }
         boolean[] visited=new boolean[n];
         int count=0;
         for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                dfs(i,adj,visited);
            }
         }
         return count;
    }
    public void dfs(int node,List<List<Integer>> adj,boolean[] visited){
        visited[node]=true;
        for(int next:adj.get(node)){
            if(!visited[next]){
                dfs(next,adj,visited);
            }
        }
    }
}
