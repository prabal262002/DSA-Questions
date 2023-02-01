class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String s = str1+str2+"";
        if(!s.equals(str2+str1+"")) return "";
        else return str1.substring(0,gcd(str1.length(),str2.length()));
    }
    public int gcd(int n,int m){
        if(m==0) return n;
        return gcd(m,n%m);
    }
}