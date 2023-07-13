class Solution {
    public int shipWithinDays(int[] nums, int k) {
        int lo = 0, hi = 0;
        for (int num : nums) {
            lo = Math.max(lo, num);
            hi += num;
        }
        
        while (lo < hi) {
            int mid = (hi + lo) / 2;
            int count = countSubarrays(nums, mid);
            
            if (count > k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        
        return lo;
    }
    private int countSubarrays(int[] nums, int maxSum) {
        int count = 0;
        int sum = 0;
        
        for (int num : nums) {
            sum += num;
            if (sum > maxSum) {
                count++;
                sum = num;
            }
        }
        
        return count+1;
    }
}