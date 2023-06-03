class Solution {
    public int reversePairs(int[] nums) {
        return merge(nums,0,nums.length-1);
    }
    public int merge(int[] nums,int lo, int hi){

        int ans =0;
        if(lo<hi){
            int mid = (lo+hi)/2;
            ans+=merge(nums,lo,mid);
            ans+=merge(nums,mid+1,hi);
            ans+=sort(nums,lo,mid,hi);
        }
        return ans;
    }

    public int sort(int[] nums, int lo, int mid, int hi){
        int n1 = mid-lo+1;
        int n2 = hi-mid;
        int[] arr = new int[n1];
        int[] brr = new int[n2];
        for(int i=0;i<n1;i++){
            arr[i] = nums[lo+i];
        }
        for(int i=0;i<n2;i++){
            brr[i] = nums[mid+i+1];
        }
        int i=0,j=0,ans=0;
        while(i<n1 && j<n2){
            if(arr[i]>2L * brr[j]){
                ans+=n1-i;
                j++;
            }
            else i++;
        }
        i=0;j=0;
        int k=lo;
        while(i<n1 && j<n2){
            if(arr[i]<=brr[j]){
                nums[k++] = arr[i++];
            }
            else{
                // if(arr[i]>2L * brr[j]){
                //     ans+=n1-i;
                // }
                nums[k++] = brr[j++];

            }
        }

        while(i<n1) {nums[k++] = arr[i++];}
        while(j<n2) {nums[k++] = brr[j++];}
        return ans;
    }
}