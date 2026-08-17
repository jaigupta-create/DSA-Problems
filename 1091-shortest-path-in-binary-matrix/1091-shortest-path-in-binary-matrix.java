class Solution {

    class Pair {
        int d, r, c;

        Pair(int d, int r, int c) {
            this.d = d;
            this.r = r;
            this.c = c;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return -1;

        int[] dr = {0, 0, -1, -1, -1, 1, 1, 1};
        int[] dc = {-1, 1, -1, 0, 1, -1, 0, 1};

        Queue<Pair> q = new LinkedList<>();

        int[][] dist = new int[n][n];

        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);

        dist[0][0] = 1;
        q.offer(new Pair(1, 0, 0));

        while (!q.isEmpty()) {

            Pair node = q.poll();

            int d = node.d;
            int r = node.r;
            int c = node.c;

            if (r == n - 1 && c == n - 1)
                return d;

            for (int k = 0; k < 8; k++) {

                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < n &&
                    grid[nr][nc] == 0 &&
                    dist[nr][nc] > d + 1) {

                    dist[nr][nc] = d + 1;

                    q.offer(new Pair(d + 1, nr, nc));
                }
            }
        }

        return -1;
    }
}