class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;

        boolean[] vis=new boolean[n];
        boolean[] path=new boolean[n];
        boolean[] check=new boolean[n];
        List<Integer> ans=new ArrayList<>();

        for(int i=0;i<n;i++){
            if(!vis[i]) dfs(graph,vis,path,i,check);
        }
        for(int i=0;i<n;i++){
            if(check[i]) ans.add(i);
        }
        return ans;
    }
    boolean dfs(int[][] graph,boolean[] vis,boolean[] path,int node,boolean[] check){
        vis[node]=true;
        path[node]=true;

        for(int i=0;i<graph[node].length;i++){
            int next = graph[node][i];
            if(!vis[next]){
                if(dfs(graph,vis,path,next,check)) return true;
            }
            else if(path[next]){
                return true;
            }
        }
        check[node]=true;
        path[node]=false;
        return false;
    }
}