class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        int arra=0;
        for(int i=0;i<n;i++){
            arra+=nums[i];
            arr[i]=arra;
        }
        // System.out.println(nums[n-1]);
        if(arr[n-1]-arr[0]==0) return 0;
        
        for(int i=1;i<n-1;i++){
            if(arr[n-1]-arr[i]==arr[i-1]) return i;
        }
        if(arr[n-2]==0) return n-1;
        return -1;
    }
}