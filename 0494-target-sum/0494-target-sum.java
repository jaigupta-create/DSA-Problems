class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        return countPartitions(n,target,nums);
    }

    public int countPartitions(int n, int diff, int[] arr) {

        int totalsum = 0;

        for (int num : arr) {
            totalsum += num;
        }

        if (totalsum - diff < 0 || (totalsum - diff) % 2 != 0)
            return 0;

        int target = (totalsum - diff) / 2;

        int[][] dp = new int[n][target + 1];

        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);

        return f(arr, n - 1, target, dp);
    }

    int f(int[] arr, int idx, int sum, int[][] dp) {

        if (idx == 0) {
            if (sum == 0 && arr[0] == 0)
                return 2;

            if (sum == 0 || sum == arr[0])
                return 1;

            return 0;
        }

        if (dp[idx][sum] != -1)
            return dp[idx][sum];

        int nottake = f(arr, idx - 1, sum, dp);

        int take = 0;
        if (sum >= arr[idx])
            take = f(arr, idx - 1, sum - arr[idx], dp);

        return dp[idx][sum] = (take + nottake);
    }
}