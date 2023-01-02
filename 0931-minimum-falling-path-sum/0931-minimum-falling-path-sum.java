class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m= matrix.length;
        int n = matrix[0].length;
        int[][] t = new int[m][n];
        for(int i=0;i<n;i++){
            t[0][i] = matrix[0][i];
        }
        for(int i=1;i<m;i++){
            for(int j = 0;j<n;j++){
                int l,r;
                if(j==0) l = Integer.MAX_VALUE;
                else l = t[i-1][j-1];
                if(j==n-1) r = Integer.MAX_VALUE;
                else r  = t[i-1][j+1];
                t[i][j] = matrix[i][j]+Math.min(t[i-1][j],Math.min(l,r));
            }
        }
        int max=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            max = Math.min(t[m-1][i],max);
        }
        return max;
    }
}