class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        HashMap<String,Integer> map=new HashMap<>();
        Disjointset d=new Disjointset(n);

        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String str=accounts.get(i).get(j);
                if(!map.containsKey(str)){ map.put(str,i);
                }else{
                    d.unionbyrank(i,map.get(str)); 
                }
            }
        }
        ArrayList<String>[] merged=new ArrayList[n];
        for(int i=0;i<n;i++) merged[i]=(new ArrayList<String>());

        for(Map.Entry<String,Integer> it: map.entrySet()){
            String str=it.getKey();
            int node=d.findpar(it.getValue());
            merged[node].add(str);
        }

        List<List<String>> ans=new ArrayList<>();

        for(int i=0;i<n;i++){
            if(merged[i].size()==0) continue;
            Collections.sort(merged[i]);
            List<String> temp=new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String str:merged[i]){
                temp.add(str);
            }
            ans.add(temp);
        }
        return ans;
    }
}
class Disjointset{
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    public Disjointset(int n){
        for(int i=0;i<n;i++){
            parent.add(i);
            rank.add(1);
        }
    }
    int findpar(int node){
        if(node==parent.get(node)) return node;
        int p=findpar(parent.get(node));
        parent.set(node,p);
        return p;
    }
    void unionbyrank(int u,int v){
        int pu=findpar(u);
        int pv=findpar(v);
        if(pu==pv) return;
        if(rank.get(pu)<rank.get(pv)){
            parent.set(pu,pv);
        }else if(rank.get(pu)>rank.get(pv)){
            parent.set(pv,pu);
        }else{
            parent.set(pu,pv);
            rank.set(pv,rank.get(pv)+1);
        }
    }
}