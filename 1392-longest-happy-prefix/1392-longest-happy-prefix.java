class Solution {
    public String longestPrefix(String s) {
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
        return s.substring(0,arr[n-1]);
    }
}