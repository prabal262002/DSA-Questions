class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int m = queries.length;
        Arrays.sort(nums);
        int[] arr=new int[n];
        int[] as=new int[m];
        int sum=nums[0];
        arr[0] = sum;
        for(int i=1;i<n;i++) {
            sum+=nums[i];
            arr[i]=sum;
        }  
        
        for(int i=0;i<m;i++){
            int t = queries[i];
            int lo=0,hi=n-1;
            int ans =0;
            while(lo<=hi){
                int mid = (lo+hi)/2;
                if(arr[mid]==t) {
                    ans = mid+1;
                    break;
                }
                else if(arr[mid]<t) {
                    lo=mid+1;
                }
                else {
                    hi = mid-1;
                }
                ans = lo;
            }

        as[i] = ans;
        }
    return as;  
    }
}