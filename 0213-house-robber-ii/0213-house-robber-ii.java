class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        else if(n==2) return Math.max(nums[0],nums[1]);
        else if(n==3) return Math.max(nums[0],Math.max(nums[1],nums[2]));
        int pre = nums[0];
        int post = Math.max(nums[1],nums[0]);
        for(int i=2;i<n-1;i++){
            int temp = post;
            post = Math.max(pre+nums[i],post);
            pre = temp;
        }
        int ans = post;
        pre = nums[n-1];
        post = Math.max(nums[n-2],nums[n-1]);
        for(int i=n-3;i>=1;i--){
            int temp = post;
            post = Math.max(pre+nums[i],post);
            pre = temp;
        }
        return (int) Math.max(ans,post);
    }
}