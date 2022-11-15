class Solution {
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        StringBuilder sb = new StringBuilder(s);
        String g = sb.reverse().toString();
        int[][] t = new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==g.charAt(j-1))
                    t[i][j] = 1+t[i-1][j-1];
                else t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
            }
        }
        return t[n][n];
    }
}