class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lo = 0,hi = nums.length-1;
        int[] arr = {-1,-1};
        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(nums[mid]==target){
                arr[0] = mid;
                hi = mid-1;
            }
            else if(nums[mid]>target) hi = mid-1;
            else lo = mid+1;
        }
        // if(lo>=0)   arr[0] = lo;
        lo = 0;hi = nums.length-1;
        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(nums[mid]==target){
                arr[1] = mid;
                lo = mid+1;
            }
            else if(nums[mid]>target) hi = mid-1;
            else lo = mid+1;
        }
        // if(hi<arr.length)   arr[1] = hi;
        return arr;
    }
}