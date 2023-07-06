class Solution {
    public int longestSubarray(int[] nums) {
        int pre=0,post=0,count=0;
        boolean odd = true;
        int max = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0 && odd){
                pre=count;
                odd=false;
                count=0;
            }
            else if(nums[i]==0 && !odd){
                post = count;
                count=0;
                max = Math.max(max,pre+post);
                pre = post;
            }
            else count++;
        }
        max = Math.max(max,pre+count);
        return (max==nums.length)?max-1:max;
    }
}