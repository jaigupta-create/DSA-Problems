class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // b -> a
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        boolean[] vis = new boolean[n];
        boolean[] path = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                if (!dfs(i, vis, path, adj))
                    return false;
            }
        }

        return true;
    }

    static boolean dfs(int node, boolean[] vis, boolean[] path,
                       ArrayList<ArrayList<Integer>> adj) {

        vis[node] = true;
        path[node] = true;

        for (int it : adj.get(node)) {

            if (!vis[it]) {
                if (!dfs(it, vis, path, adj))
                    return false;
            }
            else if (path[it]) {
                return false;   
            }
        }

        path[node] = false;
        return true;
    }
}