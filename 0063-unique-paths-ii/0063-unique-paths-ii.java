class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[] prev = new int[n];
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) break;
            prev[i] = 1;
        }

        for (int i = 1; i < m; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    temp[j] = 0;
                } else if (j == 0) {
                    temp[j] = prev[0]; 
                } else {
                    temp[j] = prev[j] + temp[j - 1];
                }
            }
            prev = temp;
        }
        return prev[n - 1];
    }
}