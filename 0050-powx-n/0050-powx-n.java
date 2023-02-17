class Solution {
    public double myPow(double x, int n) {
        double ans =  my(x,n);
        if(n>=0) return ans;
        double bns = 1/ans;
        return bns; 
    }
    public double my(double x, int n) {
        if(n==0) return 1;
        double temp = my(x,n/2);
        if((n&1)==0) return temp*temp;
        else return x*temp*temp;
    }
}