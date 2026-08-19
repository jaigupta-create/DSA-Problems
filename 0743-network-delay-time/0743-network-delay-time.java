class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<pair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<times.length;i++){
            int u=times[i][0];
            int v=times[i][1];
            int w=times[i][2];
            adj.get(u).add(new pair(v,w));
        }
        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;

        PriorityQueue<pair> q = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.second, b.second)
        );
        q.offer(new pair(k,0));

        while(!q.isEmpty()){
            pair node=q.poll();
            int u=node.first;
            int d=node.second;
            if (d > dist[u]) continue;
            for(pair it: adj.get(u)){
                int v=it.first;
                int w=it.second;
                if(dist[v]>d+w){
                    q.offer(new pair(v,d+w));
                    dist[v]=d+w;
                }
            }
        }
        int max=dist[1];
        for(int i=1;i<=n;i++){
            max=Math.max(max,dist[i]);
        }
        if(max==Integer.MAX_VALUE) return -1;
        return max;
    }

    class pair{
        int first;
        int second;
        pair(int f,int s){
            first=f;
            second=s;
        }
    }
}