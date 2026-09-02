class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int prev=nums[0];
        int prev2=0;
        int curr=-1;
        for(int i=1;i<n-1;i++){
            int pick=nums[i]+prev2;
            int notp=prev;
            curr=Math.max(pick,notp);
            prev2=prev;
            prev=curr;
        }
        int first=prev;

        n=nums.length;
        prev=nums[1];
        prev2=0;
        curr=-1;
        for(int i=2;i<n;i++){
            int pick=nums[i]+prev2;
            int notp=prev;
            curr=Math.max(pick,notp);
            prev2=prev;
            prev=curr;
        }
        return Math.max(prev,first);
    }
}