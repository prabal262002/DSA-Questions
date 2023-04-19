class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int lo=0,hi=numbers.length-1;
        int[] arr = new int[2];
        while(lo<hi){
            if(numbers[lo]+numbers[hi]==target){
                arr[0] = lo+1;
                arr[1] = hi+1;
                return arr;
            } 
            if(numbers[lo]+numbers[hi]<target) lo++;
            else hi--;
        }
        return arr;
    }
}