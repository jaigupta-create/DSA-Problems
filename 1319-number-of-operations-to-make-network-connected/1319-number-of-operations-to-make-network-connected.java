class Solution {
    public int makeConnected(int n, int[][] connections) {
        Disjointset d=new Disjointset(n);
        if (connections.length < n-1) return -1;
        for(int[] it:connections){
            int u=it[0];
            int v=it[1];
            d.unionbyrank(u,v);
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(i==d.findpar(i)) count++;
        }
        return count-1;
    }
}
class Disjointset{
    List<Integer> parent=new ArrayList<>();
    List<Integer> rank=new ArrayList<>();
    public Disjointset(int n){
        for(int i=0;i<n;i++){
            parent.add(i);
            rank.add(1);
        }
    }
    public int findpar(int node){
        if(node==parent.get(node)) return node;
        int p=findpar(parent.get(node));
        parent.set(node,p);
        return p;
    }

    public void unionbyrank(int u,int v){
        int pu=findpar(u);
        int pv=findpar(v);
        if(pu==pv) return;
        if(rank.get(pu)<rank.get(pv)){
            parent.set(pu,pv);
        }else if(rank.get(pu)>rank.get(pv)){
            parent.set(pv,pu);
        }else {
            parent.set(pu,pv);
            rank.set(pv,rank.get(pv)+1);
        }
    }
}