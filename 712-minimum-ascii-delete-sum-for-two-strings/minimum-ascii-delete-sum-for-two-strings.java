class Solution {
    private String take="";
    public int minimumDeleteSum(String s1, String s2) {
        int sum1=0;
        int sum2=0;
        // int minLen=Math.min(, s2.length());
        for(int i=0;i<s1.length();i++){
            sum1+=s1.charAt(i);            
        }
        for(int j=0;j<s2.length();j++){
            sum2+=s2.charAt(j);
        }
        int n=s1.length();
        int m=s2.length();
        int [][]dp=new int[n+1][m+1];
        for(int arr[] : dp){
            Arrays.fill(arr,-1);
        }
        int ans=lcs(s1, s2, n, m,dp);
        return sum1+sum2 -2*ans;
    }
     public int lcs(String X, String Y, int m, int n,int[][] dp){
 
        if (m == 0 || n == 0)
            return 0;
 
        if (dp[m][n] != -1)
            return dp[m][n];
 
        if (X.charAt(m - 1) == Y.charAt(n - 1)) {
            dp[m][n] = X.charAt(m-1) + lcs(X, Y, m - 1, n - 1, dp);
            return dp[m][n];
        }
 
        dp[m][n] = Math.max(lcs(X, Y, m, n - 1, dp),
                            lcs(X, Y, m - 1, n, dp));
        return dp[m][n];
    }
}