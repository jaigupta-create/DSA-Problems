class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n=numCourses;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        int[] ans=new int[n];
        int k=0;
        int[] indegree=new int[n];
        for(int i=0;i<n;i++){
            for(int it: adj.get(i)) indegree[it]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0) q.offer(i);
        }
        int count=0;
        while(!q.isEmpty()){
            int node=q.poll();
            ans[k++]=node;
            count++;

            for(int it: adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0) q.offer(it);
            }
        }

        if(count!=n) return new int[0];
        return ans;
    }
   
}