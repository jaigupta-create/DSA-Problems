class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int end=n-1;
        for(int i=n-2;i>=0;i--){
            if(i+nums[i]>=end) end=i;
        }
        return end==0;
    }
}