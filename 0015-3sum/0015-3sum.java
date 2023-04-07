class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> numl = new ArrayList<>();
         Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<n-2;i++){
            int a = nums[i];
            if(i==0 || (i!=0 && nums[i]!=nums[i-1])){
            int lo = i+1,hi=n-1;
            while(lo<hi){
                if(nums[lo]+nums[hi]==-a){
                    numl.add(Arrays.asList(a,nums[lo],nums[hi]));
                    while(lo<hi && nums[lo]==nums[lo+1]) lo++;
                    while(lo<hi && nums[hi]==nums[hi-1]) hi--;
                    lo++;
                    hi--;
                }
                else if(nums[lo]+nums[hi]<-a) lo++;
                else hi--;
            }
            }
        }
        return numl;
    }
}