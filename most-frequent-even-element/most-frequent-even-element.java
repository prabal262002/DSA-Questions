class Solution {
    public int mostFrequentEven(int[] nums) {
        if(nums.length==1 && nums[0]%2==0)
            return nums[0];
        Arrays.sort(nums);
        int max = 0,ans=-1,count=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]%2==0){
            if(nums[i]==nums[i-1]) {
                count++;   
            }
            else count=0;
            if(count>max) {
                ans = nums[i];
                max = count;
            }   
            }
        }
        if(max==0){
            for(int i=0;i<nums.length;i++){
                if(nums[i]%2==0) return nums[i];
            }
        }
        return ans;

    }
}