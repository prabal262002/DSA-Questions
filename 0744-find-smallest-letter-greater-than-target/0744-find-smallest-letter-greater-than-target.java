class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int lo =0,hi = letters.length-1;
        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(letters[mid]>target) hi = mid-1;
            else lo = mid+1;
        }
        if(lo>=letters.length) return letters[0];
        return letters[lo];
    }
}