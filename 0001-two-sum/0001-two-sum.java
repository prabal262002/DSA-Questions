class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer>  m= new HashMap<>();
        int[] arr = new int[2];
        for(int i=0;i<nums.length;i++){
            if(m.containsKey(target-nums[i])){
                arr[0]=i;
                arr[1]=m.get(target-nums[i]);
            }   
            m.put(nums[i],i);
        }
        return arr;
    }
}