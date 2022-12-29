class Solution {
    int[][] t;
    public int uniquePaths(int m, int n) {
        t = new int[m+1][n+1];
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                t[i][j]=-1;
            }
        }
        return aths(m,n);
    } 
    public int aths(int m, int n) {
        if(m==1 && n==1) return 1;
        if(m<=0 || n<=0) return 0;
        int left,right;
        if(t[m-1][n]!=-1) left = t[m-1][n];
        else {
            left = aths(m-1,n);
            t[m-1][n] = left;
        }
        if(t[m][n-1]!=-1) right = t[m][n-1];
        else {
            right = aths(m,n-1);
            t[m][n-1] = right;
        }
        return left +right;
    }
}