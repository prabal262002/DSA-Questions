class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0]>=target?1:0;
        int lo=0,hi=0;
        int ans = Integer.MAX_VALUE;
        int sum =0;
        while(hi<n){
                sum+=nums[hi];
            while(sum>=target){
                ans = Math.min(ans,hi-lo+1);
                sum-=nums[lo];
                lo++;
            }
            hi++;
        }
        return ans == Integer.MAX_VALUE?0:ans;
    }
}