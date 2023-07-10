class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        rcrsn(0,candidates,new ArrayList<>(), ans,target);
        return ans;
    }
    public void rcrsn(int indx, int[] nums, ArrayList<Integer> ds, ArrayList<List<Integer>> ans,int target){
        if(target==0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        if(indx==nums.length){
            return;
        }

        if(target-nums[indx]>=0){
            ds.add(nums[indx]);
            rcrsn(indx,nums,ds,ans,target-nums[indx]);
            ds.remove(ds.size()-1);
        } 
        rcrsn (indx+1,nums,ds,ans,target);
    }
}