class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> numl = new ArrayList<>();
         Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<n-3;i++){
            int a = nums[i];
            if(i==0 || (i!=0 && nums[i]!=nums[i-1])){
                for(int j=i+1;j<n-2;j++){
                    int b = nums[j];
                    if(j>i+1 && nums[j]==nums[j-1]) continue;
                    int lo = j+1,hi=n-1;
                        while(lo<hi){
                            if(nums[lo]+nums[hi]==(long)target-a-b){
                            numl.add(Arrays.asList(a,b,nums[lo],nums[hi]));
                            while(lo<hi && nums[lo]==nums[lo+1]) lo++;
                            while(lo<hi && nums[hi]==nums[hi-1]) hi--;
                            lo++;
                            hi--;
                            }
                        else if(nums[lo]+nums[hi]<target-a-b) lo++;
                        else hi--;
                        }
                }
            }
        }
        return numl;
    }
}