class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            boolean[] seen=new boolean [10];
            for(int j=0;j<9;j++){
                char ch=board[i][j];
                if(ch!='.'){
                    int num=ch-'0';
                    if(seen[num]) return false;
                    seen[num]=true;
                }
            }
        }
        for(int j=0;j<9;j++){
            boolean[] seen=new boolean[10];
            for(int i=0;i<9;i++){
                char ch=board[i][j];
                if(ch!='.'){
                    int num=ch-'0';
                    if(seen[num]) return false;
                    seen[num]=true;
                }
            }
        }
        for(int r=0;r<9;r+=3){
            for(int c=0;c<9;c+=3){
                boolean[] seen=new boolean[10];
                for(int i=r;i<r+3;i++){
                    for(int j=c;j<c+3;j++){
                        char ch=board[i][j];
                        if(ch!='.'){
                            int num=ch-'0';
                            if(seen[num]) return false;
                            seen[num]=true;
                        }
                    }
                }
            }
        }
        return true;

    }
}
