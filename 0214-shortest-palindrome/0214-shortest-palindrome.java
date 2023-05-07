class Solution {
    public String shortestPalindrome(String S) {
        String s = S +"#"+ new StringBuilder(S).reverse().toString();
        int i=0,j=1;
        int n = s.length();
        int[] arr = new int[n];
        while(j<n){
            if(s.charAt(i)==s.charAt(j)) {
                arr[j]=++i;
                j++;
            }
            else if(i==0) {
                arr[j]=0;
                j++;
            }
            else i = arr[i-1];
        }
        return new StringBuilder(S.substring(arr[n-1])).reverse().toString() + S;    
    }
}