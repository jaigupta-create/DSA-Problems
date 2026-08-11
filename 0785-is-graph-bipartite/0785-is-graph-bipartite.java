class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!dfs(graph, i, color, 0)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean dfs(int[][] graph, int i, int[] color, int val) {
        color[i] = val;

        for (int it : graph[i]) {

            if (color[it] == -1) {
                if (!dfs(graph, it, color, 1 - val)) {
                    return false;
                }
            } 
            else if (color[it] == val) {
                return false;
            }
        }

        return true;
    }
}