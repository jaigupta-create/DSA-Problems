class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<pair> q=new LinkedList<>();
        int fresh=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.offer(new pair(i,j));
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0) return 0;

        int time=-1;
        while(!q.isEmpty()){
            int sz=q.size();
            for(int t=0;t<sz;t++){
                pair temp=q.poll();
                int i=temp.i;
                int j=temp.j;
                if(i-1>=0 && grid[i-1][j]==1){
                    fresh--;
                    q.offer(new pair(i-1,j));
                    grid[i-1][j]=2;
                } 
                if(i+1<n && grid[i+1][j]==1){
                    fresh--;
                    q.offer(new pair(i+1,j));
                    grid[i+1][j]=2;
                } 
                if(j-1>=0 && grid[i][j-1]==1){
                    fresh--;
                    q.offer(new pair(i,j-1));
                    grid[i][j-1]=2;
                } 
                if(j+1<m && grid[i][j+1]==1){
                    fresh--;
                    q.offer(new pair(i,j+1));
                    grid[i][j+1]=2;
                }
            }
            time++;
        }
        if(fresh!=0) return -1;
        return time;

    }
    class pair{
        int i;
        int j;

        pair(int i,int j){
            this.i=i;
            this.j=j;
        }
    }
}
