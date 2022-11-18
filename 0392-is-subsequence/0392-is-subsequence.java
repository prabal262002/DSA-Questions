class Solution {
    public boolean isSubsequence(String s, String t) {
        int j=0;
        String h ="";
        if(s.equals(h)) return true;
        for(int i=0;i<t.length() && j<s.length();i++){
                if(t.charAt(i)==s.charAt(j)) j++;
            // if() return true;           
        }
        
        return j==s.length();
    }
}