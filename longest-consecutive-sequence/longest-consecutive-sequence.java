class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> m = new HashSet<>();
        for(int a:nums){
            m.add(a);
        }
        int md=0;
        for(int i=0;i<nums.length;i++){
            if(!m.contains(nums[i]-1)){
                int sum=1;
                int st = nums[i];
                while(m.contains(st+sum)){
                    sum++;
                }
                md = Math.max(md,sum);
            }
        }
        return md;
    }
}