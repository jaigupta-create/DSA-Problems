class Solution {

    public int numIslands(char[][] grid) {
        int count=0;
        int n=grid.length;
        int m=grid[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         if(grid[i][j]=='2'){
        //             grid[i][j]='1';
        //         }
        //     }
        // }
        return count;
        
    }
    void dfs(char[][] grid,int i,int j){
        int n=grid.length;
        int m=grid[0].length;
        if(i>=n || i<0 || j>=m || j<0 || grid[i][j]!='1') return;
        grid[i][j]='2';
        int[] dr={0,0,-1,1};
        int[] dc={-1,1,0,0};
        for(int k=0;k<4;k++){
            int nr=i+dr[k];
            int nc=j+dc[k];
            dfs(grid,nr,nc);
        }
    }
}