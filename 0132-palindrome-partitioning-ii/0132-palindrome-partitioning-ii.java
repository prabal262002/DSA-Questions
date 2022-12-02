class Solution {
    int [][] t;
    int[][] b;
    public int minCut(String s) {
        int i =0,j=s.length()-1;
        t = new int[j+2][j+2];
        b = new int[j+2][j+2];
        for(int[] a : t){
            Arrays.fill(a,-1);
        }
        for(int[] a : b){
            Arrays.fill(a,-1);
        }
        
        return leet(s,i,j);
    }
    public boolean isPalindrome(String s, int i,int j){
        if(b[i][j] != -1) return b[i][j]==1;
        if(i>=j) {b[i][j]=1;return true;}
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                b[i][j]=0;
                return false;
            }
            i++;j--;
        }
        b[i][j]=1;
        return true;
    }
    public int leet(String s, int i,int j){
        if(i>=j) return 0;
        if(t[i][j]!=-1) return t[i][j];
        if(isPalindrome(s,i,j)==true) return 0;
        int min = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            if(isPalindrome(s,i,k)){
            if(t[i][k]==-1) t[i][k]=leet(s,i,k);
            if(t[k+1][j]==-1) t[k+1][j]=leet(s,k+1,j);
            int temp  = t[i][k]+t[k+1][j]+1;
            min = Math.min(min,temp);}
        }
        t[i][j] = min;
        return t[i][j];
    }
}