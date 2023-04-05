class Solution {
    public int minimizeArrayValue(int[] nums) {
        long sum =0,result=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            result = Math.max(result,(sum+i)/(i+1));
        }
        return (int)result;
    }
}
