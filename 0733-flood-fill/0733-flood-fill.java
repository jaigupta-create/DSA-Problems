class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n=image.length;
        int m=image[0].length;
        int target=image[sr][sc];
        if(target==color) return image;

        Queue<pair> q=new LinkedList<>();
        q.offer(new pair(sr,sc));
        image[sr][sc]=color;

        int[] r={-1,1,0,0};
        int[] c={0,0,-1,1};

        while(!q.isEmpty()){
            pair temp=q.poll();
            int i=temp.i;
            int j=temp.j;

            for(int k=0;k<4;k++){
                int nr=i+r[k];
                int nc=j+c[k];
                if(nr>=0 && nr<n && nc>=0 && nc<m && image[nr][nc]==target){
                    q.offer(new pair(nr,nc));
                    image[nr][nc]=color;
                }
            }
        }
        return image;
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