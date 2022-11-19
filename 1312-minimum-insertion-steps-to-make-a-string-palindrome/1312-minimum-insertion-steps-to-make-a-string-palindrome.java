class Solution {
    public int minInsertions(String s) {
        StringBuffer Ts = new StringBuffer(s);
        String T = Ts.reverse().toString();
        int n=s.length();
        int[][] t= new int[n+1][n+1]; 
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                if(s.charAt(i-1)==T.charAt(j-1)) t[i][j]=t[i-1][j-1]+1;
                else t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
            }
        }
        return n-t[n][n];
    }
}