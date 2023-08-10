class Solution {
    public boolean search(int[] nums, int target) {
        int pivot=pivot(nums);
        //pivot will be the index of the largest number in array
        if(pivot==-1){
            return binarysearch(nums,target,0,nums.length-1);
        }
        if(nums[pivot]==target){
            return true;
        }
        if(target>=nums[0]){
            return binarysearch(nums,target,0,pivot);
        }return binarysearch(nums,target,pivot+1,nums.length-1);
    }
    public boolean binarysearch(int nums[],int target,int start,int end){
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                return true;
            }else if(nums[mid]>target){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return false;
    }
    public int pivot(int nums[]){
        int start=0;
        int end=nums.length-1;
        while(start<end){
            int mid=start+(end-start)/2;
            
            if(mid<end && nums[mid]>nums[mid+1]){
                return mid;
                //the whole array will be in increasing sorted but only one point will come where the next number will be decreasing 
            }
            if(mid>start && nums[mid]<nums[mid-1]){
                return mid-1;
                //if it is the decreasing part return mid-1 ele index
            }
            if(nums[start]==nums[mid]&&nums[end]==nums[mid]){
                //if we find start==mid==end then we can just simply ignore first and last element
                if(nums[start]>nums[start+1]){
                    return start;
                    //but we must check what if the number we were ignoring was the pivot!!
                }
                start++;
                if(nums[end]<nums[end-1]){
                    return end-1;
                    //same check for last element
                }
                end--;
            }
            else if(nums[start]<nums[mid] ||( nums[start]==nums[mid]&& nums[mid]>nums[end] )){
                start=mid+1;
                //if we are in left sorted array
            }
            else{
                end=mid-1;
            }
        }
        return -1;
    }
}