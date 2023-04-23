class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        int p=1;
        for(int i=0;i<n;i++){
            arr[i]=p;
            p*=nums[i];
        }
        p=1;
        for(int i=n-1;i>=0;i--){
            arr[i]*=p;
            p*=nums[i];
        }
        return arr;
    }
}