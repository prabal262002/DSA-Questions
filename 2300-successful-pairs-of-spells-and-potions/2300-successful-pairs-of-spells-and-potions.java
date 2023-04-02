class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
       Arrays.sort(potions);
       int[] arr = new int[spells.length];
       for(int i=0;i<spells.length;i++){
           double a = spells[i];
           int lo=0,hi=potions.length-1;
           while(lo<=hi){
               int mid = (lo+hi)/2;
               if(a*potions[mid]<success) lo = mid+1;
               else hi = mid-1;
           }
           arr[i] = potions.length-lo;
       }
       return arr;
    }
}