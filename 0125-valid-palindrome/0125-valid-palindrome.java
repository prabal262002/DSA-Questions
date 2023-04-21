class Solution {
    public boolean isPalindrome(String s) {
        int lo=0,hi=s.length()-1;
        while(lo<hi){
            char a = s.charAt(lo);
            char b = s.charAt(hi);
            if(!Character.isLetterOrDigit(a)) lo++;
            else if(!Character.isLetterOrDigit(b)) hi--;
            else{
                if(Character.toLowerCase(a)!=Character.toLowerCase(b))
                    return false;
                lo++;hi--;
            }
        }
        return true;
    }
}