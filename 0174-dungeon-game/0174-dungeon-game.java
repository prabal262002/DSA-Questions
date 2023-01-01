class Solution {
    int[][] t;
    public int calculateMinimumHP(int[][] dun) {
        int m = dun.length;
        int n = dun[0].length;
        // t = new int[m+1][n+1];
        // for(int[] a:t){
        //     Arrays.fill(a,-1);
        // }
        // return leet(dun,m,n);
        
        
        int[][] t = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                t[i][j] = Integer.MAX_VALUE;
            }
        }
        
        t[m][n-1] = 1;
        t[m-1][n] =1;
        // // t[0][1]=1-dun[0][1]<=0?1:-dun[0][1];
        // // t[1][0]=1-dun[1][0]<=0?1:-dun[1][0];
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int ans = Math.min(t[i+1][j],t[i][j+1])-dun[i][j];
                t[i][j] = (ans<=0)?1:ans;
            }
        }
        return t[0][0];
    }
    // public int leet(int[][] dun,int m,int n){
    //     if(m==0 && n==0) return dun[0][0]<=0?1-dun[0][0]:1;
    //     if(m==0 || n==0) return Integer.MAX_VALUE;
    //     if(t[m][n]!=-1) return t[m][n];
    //     if(t[m][n-1]==-1)   t[m][n-1] = leet(dun,m,n-1);
    //     if (t[m-1][n]==-1) t[m-1][n] = leet(dun,m-1,n);
    //     int ter = Math.min(t[m][n-1],t[m-1][n])-dun[m-1][n-1];
    //     t[m][n] = ter<=0?1:ter;
    //     return t[m][n];
    // }
}