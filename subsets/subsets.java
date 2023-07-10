class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        recursion(0,nums, new ArrayList<>(), ans);
        return ans;
    }
    public void recursion (int index,int[] nums, List<Integer> ds,List<List<Integer>> ans){
        if(index>=nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        recursion(index+1,nums, ds, ans);
        ds.add(nums[index]);
        recursion(index+1,nums,ds,ans);
        ds.remove(ds.size()-1);
    }
}