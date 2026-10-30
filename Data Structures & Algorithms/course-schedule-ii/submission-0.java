class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree=new int[numCourses];
        for(int[] p:prerequisites){
            int a=p[0];
            int b=p[1];
            adj.get(b).add(a);
            indegree[a]++;
        }
        Queue<Integer> q=new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int[] result=new int[numCourses];
        int index=0;
        while(!q.isEmpty()){
            int course=q.poll();
            result[index++]=course;
            for(int next:adj.get(course)){
                indegree[next]--;
                if(indegree[next]==0){
                    q.add(next);
                }
            }
        }
        if(index!=numCourses){
            return new int[0];
        }
        return result;
    }
}
