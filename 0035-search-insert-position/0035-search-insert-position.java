class Solution {
    public int searchInsert(int[] arr, int target) {
        int lo = 0,hi = arr.length-1;
        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(arr[mid]==target) return mid;
            else if(arr[mid]>target) hi = mid-1;
            else lo = mid+1;
        }
        // System.out.println("JJ");
        return lo;
    }
}