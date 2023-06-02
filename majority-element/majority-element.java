class Solution {
    public int majorityElement(int[] nums) {
        int count=1,n=nums.length,j=0;
        for(int i=1;i<n;i++){
            if(nums[i]==nums[j]) count++;
            else count--;
            if(count==0) {j=i;count=1;}
        }
        // count=0;
        // for(int i=0;i<n;i++){
        //     if(nums[i]==nums[j]) count++;
        // }
        // if(count>n/2) return nums[j];
        // else return 0;
        return nums[j];
    }
}