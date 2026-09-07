class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> prev=new ArrayList<>();
        prev.add(triangle.get(0).get(0));
        for(int i=1;i<triangle.size();i++){
            List<Integer> curr=new ArrayList<>();
            for(int j=0;j<triangle.get(i).size();j++){
                int num=triangle.get(i).get(j);
                if(j>0 && j<prev.size()) num=Math.min(num+prev.get(j-1),num+prev.get(j));
                else{
                    if(j==0) num+=prev.get(j);
                    else num+=prev.get(j-1);
                }
                curr.add(num);
            }
            prev=curr;
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<prev.size();i++){
            ans=Math.min(ans,prev.get(i));
        }
        return ans;
    }
}