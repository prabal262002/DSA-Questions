class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int curr=Integer.MIN_VALUE,fin = Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            fin = Math.max(fin,sum);
            if(sum<0) sum=0;
            
        }
        return fin;
    }
}