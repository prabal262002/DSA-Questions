class Solution {
    public int search(int[] nums, int target) {
        int peak = peak(nums);
        if(peak==-1){
            // Array is not rotated
            return binarySearch(nums,target,0,nums.length-1);
        }
        if(target==nums[peak]) return peak;
        else if(target>=nums[0]) return binarySearch(nums,target,0,peak-1);
        else return binarySearch(nums,target,peak+1,nums.length-1);
        
    }
    public int binarySearch(int[] nums,int target,int lo,int hi){
        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid]<target) lo = mid+1;
            else hi = mid-1;
        }
        return -1;
    }
    public int peak (int[] nums){
        int lo = 0;
        int hi = nums.length-1;
        while(lo<=hi){
            int mid  = (lo+hi)/2;
            if(mid<hi && nums[mid]>nums[mid+1]) return mid;
            else if(mid>0 && nums[mid]<nums[mid-1]) return mid-1;
            if(nums[mid]<nums[lo]) hi = mid-1;
            else lo = mid+1;
        }
        return -1;
    }
}