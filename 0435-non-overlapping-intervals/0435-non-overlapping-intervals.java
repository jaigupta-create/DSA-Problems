class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> a[1]-b[1]
        );
        int n=intervals.length;
        int count=0;
        int i=1;
        int prev=intervals[0][1];
        while(i<n){
            if(intervals[i][0]<prev){
                count++;
            }else{
                prev=intervals[i][1];
            }
            i++;
        }
        return count;
    }
}