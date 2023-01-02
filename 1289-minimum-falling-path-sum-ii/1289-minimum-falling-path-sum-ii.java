class Solution {
    int[][] t;
    public int minFallingPathSum(int[][] grid) {
        int m  = grid.length;
        int n = grid[0].length;
        t = new int[m+1][n+1];
        for(int[] a:t){
            Arrays.fill(a,Integer.MAX_VALUE);
        }
        int max = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int ans = leet(grid,m-1,i);
            max = Math.min(max,ans);
        }
        return max;
    }
    public int leet(int[][] grid,int m ,int n){
        if(n<0 || n>grid[0].length-1) return Integer.MAX_VALUE;
        if(m==0) return grid[m][n];
        if(t[m][n]!=Integer.MAX_VALUE) return t[m][n];
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<grid[0].length;i++){
            if(i!=n) {
            int an = leet(grid,m-1,i)+grid[m][n];
            ans = Math.min(ans,an);
            }
        }
        t[m][n] = ans;
        return ans;
    }
}