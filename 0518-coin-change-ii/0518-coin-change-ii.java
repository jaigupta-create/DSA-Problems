class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int k=0;k<=amount;k++){
            if(k%coins[0]==0) dp[0][k]=1;
            else dp[0][k]=0;
        }
        for(int i=1;i<n;i++){
            for(int k=0;k<=amount;k++){
                int nottake=dp[i-1][k];
                int take=0;
                if(coins[i]<=k) take=dp[i][k-coins[i]];
                dp[i][k]=take+nottake;
            }
        }
        return dp[n-1][amount];
    }
}