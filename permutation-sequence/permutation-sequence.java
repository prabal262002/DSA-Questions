class Solution {
    public String getPermutation(int n, int k) {
        ArrayList<Integer> nums = new ArrayList<>();
        int f=1;
        for(int i=1;i<=n;i++){
            nums.add(i);
            f*=i;
        }
        f/=n;
        StringBuilder ans = new StringBuilder();
        k--;
        while(!nums.isEmpty()){
            int i = (k/f);
            ans.append(nums.get(i));
            nums.remove(i);
            if(nums.isEmpty()) break;
            k%=f;
            f/=nums.size();
        }
        return ans.toString();
    }
}