class Solution {
    public int climbStairs(int n) {
        if(n==0||n==1) return 1;
        int prev=1;
        int sprev=1;
        int curr=prev+sprev;
        for(int i=0;i<n-2;i++){
            sprev=prev;
            prev=curr;
            curr=prev+sprev;
        }
        return curr;
    }
}