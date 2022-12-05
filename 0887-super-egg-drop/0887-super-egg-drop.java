class Solution {
    
    public int superEggDrop(int k, int n) {
        int[][] t = new int[k+1][n+1];
        for(int[] a:t){
            Arrays.fill(a,-1);
        }
        return leet(k,n,t);
    }
    public int leet(int k, int n,int[][] t){
        if (n <= 1) {
            return n;
        }
        if (k == 1) {
            return n;
        }
        if(t[k][n]!=-1) return t[k][n];
        int min = Integer.MAX_VALUE;
        int lo=0,hi=n;
        while(lo<hi){
            int i = (lo + hi)/2;
            int p,q;
            if(t[k][n-i]!=-1) q = t[k][n-i];
            else{
            q = leet(k,n-i,t);
            t[k][n-i] = q;}
            
            if(t[k-1][i-1]!=-1) p = t[k-1][i-1];
            else{
            p = leet(k-1,i-1,t);
            t[k-1][i-1] = p;}
            
            int temp = 1+Math.max(q,p);
            min  = Math.min(min,temp);
            if (p==q) break;
            if(p<q) lo = i +1;
            else hi = i;
        }
        t[k][n] = min;
        return min;
    }
}