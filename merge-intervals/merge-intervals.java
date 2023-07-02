class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        ArrayList<int[]> ans = new ArrayList<>();
        int s = intervals[0][0];
        int e = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=e)
            e = Math.max(intervals[i][1],e);
            else {
                int[] arr = new int[2];
                arr[0] = s;
                arr[1] = e;
                ans.add(arr);
                s = intervals[i][0];
                e = intervals[i][1];
            }
        }
        int[] arr = new int[2];
        arr[0] = s;arr[1] = e;
        ans.add(arr);
        return ans.toArray(new int[0][]);
    }
}