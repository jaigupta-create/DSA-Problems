class Solution {
    int f(int[] coins, int idx, int tar, int[][] dp){
        if(idx==0){
            if(tar%coins[idx]==0) return tar/coins[idx];
            else return (int)1e9;
        }
        if(dp[idx][tar]!=(-1)) return dp[idx][tar];
        int nottake=f(coins,idx-1,tar, dp);
        int take=(int)(1e9);
        if(coins[idx]<=tar) take=1+f(coins,idx,tar-coins[idx],dp);

        return dp[idx][tar] = Math.min(nottake, take);
    }
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[] dp=new int[amount+1];
        // for(int[] arr: dp) Arrays.fill(arr,-1);
        // int ans=f(coins, n-1, amount, dp);
        // if(ans>=(1e9)) ans=-1;
        // return ans;

        for(int k=0;k<=amount;k++){
            if(k%coins[0]==0) dp[k]=k/coins[0];
            else dp[k]=(int)(1e9);
        }
        for(int idx=1;idx<n;idx++){
            int[] curr=new int[amount+1];
            for(int tar=0;tar<=amount;tar++){
                int nottake=dp[tar];
                int take=(int)(1e9);
                if(coins[idx]<=tar) take=curr[tar-coins[idx]]+1;

                curr[tar]=Math.min(nottake,take);
            }
            dp=curr;
        }
        if(dp[amount]>=(1e9)) return -1;
        return dp[amount];
    }
}