class Solution {
    public void swap (int[] nums,int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length-1;
        int first =-1,second=-1;
        for(int i=n;i>0;i--){
            if(nums[i]>nums[i-1]) {
                first= i-1;
                break;            
            }
        }
        if(first==-1) {
            // Collections.reverse(Arrays.asList(nums));
            int lo=0,hi=n;
            while(lo<hi){
                swap(nums,lo++,hi--);
            }
        }
        else{
        for(int i=n;i>=0;i--){
            if(nums[i]>nums[first]) {
                second = i;
                break;
            }
        }
        swap(nums,first,second);
        first++;
        second=n;
        while(first<second){
            swap(nums,first,second);
            first++;
            second--;
        }    
        }
    }
}