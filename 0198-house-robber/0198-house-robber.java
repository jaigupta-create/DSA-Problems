class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int prev=nums[0];
        int prev2=0;
        int curr=-1;
        for(int i=1;i<n;i++){
            int pick=nums[i]+prev2;
            int notp=prev;
            curr=Math.max(pick,notp);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
}