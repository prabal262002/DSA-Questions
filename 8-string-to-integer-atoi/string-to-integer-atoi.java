class Solution {
    public int myAtoi(String s) {
        int i=0;
        int n = s.length();
        while(i<n && s.charAt(i)== ' ') i++;
        int sign = 1;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        double ans=0D;
        while(i<n && s.charAt(i)>= '0' && s.charAt(i)<='9'){
            ans*=10;
            ans+=s.charAt(i) - '0';
            if(sign*ans>Integer.MAX_VALUE) return Integer.MAX_VALUE;
            else if(sign*ans<Integer.MIN_VALUE) return Integer.MIN_VALUE;
            i++;
        }



         return (int) (sign * ans);
    }
}