class Solution {
    int[][]t = new int [1001][1001];
    public int longestCommonSubsequence(String text1, String text2) {
        for(int[] i:t)  Arrays.fill(i,-1);
        return gg(text1,text2,text1.length(),text2.length());
    }
    public int gg(String a, String b,int n, int m) {
        if(n==0 || m==0) return 0;
        if(t[n][m]!=-1) return t[n][m];
        if(a.charAt(n-1)==b.charAt(m-1))
            t[n][m]= 1+gg(a,b,n-1,m-1);
        else 
            t[n][m]=Math.max(gg(a,b,n-1,m),gg(a,b,n,m-1));
        
        return t[n][m];
    }    
}
