class Solution {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> l = new ArrayList<>();
        ArrayList<Integer> ds = new ArrayList<>();
        boolean[] arr = new boolean[nums.length];
        rcrsn(nums, l, ds, arr);  
        return l;  
    }
    public void rcrsn(int[] nums,ArrayList<List<Integer>> l,ArrayList<Integer> ds,boolean[] arr){
        if(ds.size()==nums.length){
            l.add(new ArrayList<>(ds));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!arr[i]){
                arr[i]=true;
                ds.add(nums[i]);
                rcrsn(nums,l,ds,arr);
                ds.remove(ds.size()-1);
                arr[i] = false;
            }
        }    
    }
}