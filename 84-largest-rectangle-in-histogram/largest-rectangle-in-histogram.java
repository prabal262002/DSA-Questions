class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stck = new Stack<>();
        for(int i=0;i<n;i++){
            while(!stck.isEmpty() && heights[i]<=heights[stck.peek()]){
                stck.pop();
            }
            left[i] = stck.isEmpty() ? 0 : stck.peek() + 1;  
            stck.push(i);
        }
        stck.clear();
        for(int i=n-1;i>=0;i--){
            while(!stck.isEmpty() && heights[i]<=heights[stck.peek()]){
                stck.pop();
            }
            right[i] = stck.isEmpty() ? n - 1 : stck.peek() - 1;
            stck.push(i);
        }
        int max = 0;
        for(int i=0;i<n;i++){
            max = Math.max(max,heights[i]*(right[i]-left[i]+1));
        }
        return max;
    }
}