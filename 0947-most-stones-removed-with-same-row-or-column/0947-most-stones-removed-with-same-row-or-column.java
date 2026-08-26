class Solution {
    public int removeStones(int[][] stones) {
        int n=stones.length;
        int maxrow=0;
        int maxcol=0;
        for(int[] it:stones){
            maxrow=Math.max(maxrow,it[0]);
            maxcol=Math.max(maxcol,it[1]);
        }
        Disjointset d=new Disjointset(maxrow+maxcol+2);
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int[] it: stones){
            int noderow=it[0];
            int nodecol=it[1]+maxrow+1;
            d.unionbyrank(noderow,nodecol);
            map.put(noderow,1);
            map.put(nodecol,1);
        }
        int count=0;
        for(int key:map.keySet()){
            if(key==d.findpar(key)) count++;
        }
        return n-count;
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