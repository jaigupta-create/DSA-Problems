class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        int[][] dist=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        PriorityQueue<pair> q=new PriorityQueue<>( (a, b) -> Integer.compare(a.dist, b.dist) );
        q.offer(new pair(0,0,0));
        dist[0][0]=0;

        int[] dr={0,0,-1,1};
        int[] dc={1,-1,0,0};
        while(!q.isEmpty()){
            pair node=q.poll();
            int d=node.dist;
            int i=node.i;
            int j=node.j;
            if (i == n - 1 && j == m - 1) return d;
            for(int k=0;k<4;k++){
                int nr=i+dr[k];
                int nc=j+dc[k];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    int edge = Math.abs(heights[nr][nc] - heights[i][j]);
                    int newEffort = Math.max(d, edge);

                    if (newEffort < dist[nr][nc]) {
                        dist[nr][nc] = newEffort;
                        q.offer(new pair(newEffort, nr, nc));
                    }
                }
            }
        }
        return dist[n-1][m-1];
    }
    class pair{
        int dist;
        int i;
        int j;
        pair(int dist,int i,int j){
            this.dist=dist;
            this.i=i;
            this.j=j;
        }
    }
}