class Solution {
    int [] t;
    public int climbStairs(int n) {
        t= new int[n+2];
        Arrays.fill(t,-1);
        return leet(0,n);
    }
    public int leet(int a,int n){
      if (a>n) return 0;
      if (a==n) return 1;
      if(t[a]!=-1) return t[a];
      t[a+1] = leet(a+1,n);
      t[a+2] = leet(a+2,n);
      return t[a+1]+t[a+2];
    }
}