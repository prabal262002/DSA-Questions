class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k%=n;
        reverse(nums,0,n-k-1);
        reverse(nums,n-k,n-1);
        reverse(nums,0,n-1);
    }
    public void reverse(int[] nums, int i,int k) {
        while(i<k){
            int temp = nums[k];
            nums[k] = nums[i];
            nums[i] = temp;
            i++;k--;
        }
    }
}