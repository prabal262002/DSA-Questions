class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<List<Integer>> l = new ArrayList<>();
        Arrays.sort(nums);
        findSubset(0,nums,new ArrayList<>(),l);
        return l;
    }
    public void findSubset(int ind,int[] nums,List<Integer> ds,List<List<Integer>> l){
        l.add(new ArrayList<Integer>(ds));
        for(int i=ind;i<nums.length;i++){
            if(i!=ind && nums[i]==nums[i-1]) continue;
            ds.add(nums[i]);
            findSubset(i+1,nums,ds,l);
            ds.remove(ds.size()-1);
        }
    }
}