class Solution {
    int[] dr = {0, 0, -1, 1};
    int[] dc = {-1, 1, 0, 0};

    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // Top and bottom
        for(int i = 0; i < m; i++) {
            if(grid[0][i] == 1)
                dfs(grid, 0, i);

            if(grid[n-1][i] == 1)
                dfs(grid, n-1, i);
        }

        // Left and right
        for(int i = 0; i < n; i++) {
            if(grid[i][0] == 1)
                dfs(grid, i, 0);

            if(grid[i][m-1] == 1)
                dfs(grid, i, m-1);
        }

        int count = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    count++;
                }
                else if(grid[i][j] == 2) {
                    grid[i][j] = 1;
                }
            }
        }

        return count;
    }

    void dfs(int[][] grid, int i, int j) {
        int n = grid.length;
        int m = grid[0].length;

        if(i < 0 || i >= n ||
           j < 0 || j >= m ||
           grid[i][j] != 1) {
            return;
        }

        grid[i][j] = 2;

        for(int k = 0; k < 4; k++) {
            int nr = i + dr[k];
            int nc = j + dc[k];

            dfs(grid, nr, nc);
        }
    }
}