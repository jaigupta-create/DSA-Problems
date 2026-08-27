class Solution {
    public boolean isvalid(int nr,int nc,int n){
        return (nr>=0 && nr<n && nc<n && nc>=0);
    }
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        Disjointset d=new Disjointset(n*n+1);
        int size=0;

        int[] dr={0,0,-1,1};
        int[] dc={-1,1,0,0};
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    for(int k=0;k<4;k++){
                        int nr=i+dr[k];
                        int nc=j+dc[k];
                        if(isvalid(nr,nc,n) && grid[nr][nc]==1){
                            int node=i*n+j;
                            int cnode=nr*n+nc;
                            d.unionbysize(node,cnode);
                        }
                    }
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    HashSet<Integer> components=new HashSet<>();
                    for(int k=0;k<4;k++){
                        int nr=i+dr[k];
                        int nc=j+dc[k];
                        if(isvalid(nr,nc,n) && grid[nr][nc]==1){
                            int node=i*n+j;
                            int cnode=nr*n+nc;
                            components.add(d.findpar(n*nr+nc));
                        }
                    }
                    int sz=1;
                    for(int parent:components){
                        sz+=d.size.get(parent);
                    }
                    size=Math.max(size,sz);
                }
            }
        }
        for(int i=0;i<n*n;i++){
            size=Math.max(size,d.size.get(d.findpar(i)));
        }
        return size;
    }
}
class Disjointset{
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public Disjointset(int n){
        for(int i=0;i<n;i++){
            parent.add(i);
            rank.add(1);
            size.add(1);
        }
    }
    int findpar(int node){
        if(node==parent.get(node)) return node;
        int p=findpar(parent.get(node));
        parent.set(node,p);
        return p;
    }
    public void unionbysize(int u, int v) {
        int pu = findpar(u);
        int pv = findpar(v);

        if (pu == pv) return;

        if (size.get(pu) < size.get(pv)) {
            parent.set(pu, pv);
            size.set(pv, size.get(pv)+size.get(pu));
        }else {
            parent.set(pv, pu);
            size.set(pu, size.get(pv) + size.get(pu));
        }
    }
}