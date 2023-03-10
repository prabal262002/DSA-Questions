class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int lo =0,hi = arr.length-1;
        int max = 0;
        while(lo<hi){
            int mid = (lo+hi)/2;
            //if(arr[mid+1]<arr[mid] && arr[mid-1]<arr[mid]) return mid;
            // ^^Above line can be ommitted.
            if(arr[mid+1]<arr[mid]) hi = mid; // {\}
            else lo = mid+1;
        }
        return lo;
    }
}