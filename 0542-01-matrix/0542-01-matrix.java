class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0) q.offer(new Pair(i,j));
            }
        }

        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        int len = 0;

        while(!q.isEmpty()){
            int sz = q.size();
            len++;
            for(int t=0;t<sz;t++){
                Pair temp = q.poll();
                int i=temp.i;
                int j=temp.j;

                for(int k=0;k<4;k++){
                    int nr=i+dr[k];
                    int nc=j+dc[k];

                    if(nr>=0 && nr<n && nc>=0 && nc<m && !vis[nr][nc] && mat[nr][nc] > 0){
                        mat[nr][nc]=len;
                        q.offer(new Pair(nr,nc));
                        vis[nr][nc]=true;
                    }
                }
            }
        }
        return mat;
    }
    class Pair{
        int i;
        int j;
        Pair(int i,int j){
            this.i = i;
            this.j = j;
        }
    }
}