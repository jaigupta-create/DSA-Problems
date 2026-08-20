class Solution {
    public int countPaths(int n, int[][] roads) {
        int mod=1000000007;
        ArrayList<ArrayList<pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<roads.length;i++){
            int u=roads[i][0];
            int v=roads[i][1];
            int d=roads[i][2];
            adj.get(u).add(new pair(v, (long)d));
            adj.get(v).add(new pair(u, (long)d));
        }
        long[] dist=new long[n];
        int[] ways=new int[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        Arrays.fill(ways,0);

        PriorityQueue<pair> q=new PriorityQueue<>(
            (a,b) -> Long.compare(a.second,b.second)
        );

        dist[0]=0;
        ways[0]=1;
        q.offer(new pair(0,0L));
        
        while(!q.isEmpty()){
            pair node=q.poll();
            int u=node.first;
            long d=node.second;
            if (d > dist[u]) continue;
            for(pair it: adj.get(u)){
                int v=it.first;
                long cost=it.second;
                if(dist[v]==dist[u]+cost){ 
                    ways[v] = (ways[v] + ways[u]) % mod;
                }
                else if(dist[v]>dist[u]+cost) {
                    ways[v]=ways[u];
                    dist[v]=dist[u]+cost;
                    q.offer(new pair(v,(long)dist[v]));
                }
            }
        }
        return ways[n-1];
    }

    class pair{
        int first;
        long second;
        pair(int first,long second){
            this.first=first;
            this.second=second;
        }
    }
}