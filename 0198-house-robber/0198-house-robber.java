class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int pre =nums[0];
        int post = Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            int temp = post;
            post = Math.max(pre+nums[i],post);
            pre = temp;
        }
        return post;
    }
}