class Solution {
    public int maxArea(int[] height) {
        int lo=0,hi=height.length-1;
        int area=0;
        while(lo<hi){
            area = Math.max(area,(hi-lo)*Math.min(height[hi],height[lo]));
            if(height[lo]>height[hi]) hi--;
            else lo++;
        }
        return area;
    }
}