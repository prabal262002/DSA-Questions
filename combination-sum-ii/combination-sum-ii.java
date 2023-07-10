class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        rcrsn(0,candidates,target, new ArrayList<>(),ans);
        return ans;
    }

    public void rcrsn (int indx, int[] nums, int target, ArrayList<Integer> ds, ArrayList<List<Integer>> ans){
        if(target== 0){
            ans.add(new ArrayList<>(ds));
            return ;
        }
        for(int i=indx;i<nums.length;i++){
            if(i!=indx && nums[i]==nums[i-1]) continue;
            if(target<nums[i]) break;/* Because nums is in sorted order and after nums[i] there will be no element less than nums[i].*/
            ds.add(nums[i]);
            rcrsn(i+1,nums,target-nums[i],ds,ans);
            ds.remove(ds.size()-1);
        }
    }
}