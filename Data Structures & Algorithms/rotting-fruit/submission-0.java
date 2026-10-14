class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int fresh=0;
        int time=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        while(fresh>0){
            boolean changed=false;
            int[][] temp=new int[m][n];
            for(int i=0;i<m;i++){
                temp[i]=grid[i].clone();
            }
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(grid[i][j]==2){
                        if(i>0 && grid[i-1][j]==1){
                            temp[i-1][j]=2;
                        }
                        if(i<m-1 && grid[i+1][j]==1){
                            temp[i+1][j]=2;
                        }if(j>0 && grid[i][j-1]==1){
                            temp[i][j-1]=2;
                        }
                        if(j<n-1 && grid[i][j+1]==1){
                            temp[i][j+1]=2;
                        }
                    }
                }
            }
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(grid[i][j]==1 && temp[i][j]==2){
                        fresh--;
                        changed=true;
                    }
                }
            }
            if(!changed) return -1;
            grid=temp;
            time++;
        }
        return time;
    }
}
