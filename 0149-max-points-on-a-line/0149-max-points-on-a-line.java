class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if(n==1) return 1;
        int max = Integer.MIN_VALUE;
// ArrayList<Integer> l = new ArrayList<>();
        for(int j=0;j<n;j++){
            int x1 = points[j][1];
            int y1 = points[j][0];
            HashMap<Double,Integer> m = new HashMap<>();
        for(int i=0;i<n;i++){
            if(i==j) continue;
            int x2 = points[i][1];
            int y2 = points[i][0];
            double slope=Integer.MAX_VALUE;
            if(y2!=y1) {
                slope = (x2-x1)/(double)(y2-y1);
                }
            m.put(slope,m.getOrDefault(slope,0)+1);
            max = Math.max(max,m.get(slope));
            }
        }
            
        return max+1;
    }
}