class Solution {
    int[][] t;
    public int minPathSum(int[][] grid) {
         int m = grid.length;
        int n = grid[0].length;
        t = new int[m+1][n+1];
        for(int[] a:t){
            Arrays.fill(a,-1);
        }
       
        return leet(grid,m-1,n-1);
    }
    
    public int leet (int[][] grid,int m,int n){
        if(m==0 && n==0) return grid[m][n];
        if(m<0 || n<0) return Integer.MAX_VALUE;
        if(t[m][n]!=-1) return t[m][n];
        // if(t[m-1][n]==-1)   t[m-1][n]=leet(grid,m-1,n);
        // if(t[m][n-1]==-1)   t[m][n-1]=leet(grid,m,n-1);
        int left = leet(grid,m-1,n);
        int up = leet(grid,m,n-1);
        t[m][n] = Math.min(left,up)+grid[m][n];
        return t[m][n];
    }
}