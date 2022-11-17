class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        long a1 = Math.abs((ax2-ax1)*(ay1-ay2)) + Math.abs((bx2-bx1)*(by1-by2));
        int left = Math.max(ax1,bx1), right = Math.max(Math.min(ax2,bx2), left);
        int bottom = Math.max(ay1,by1), top = Math.max(Math.min(ay2,by2), bottom);
        return (int)a1-(right-left)*(top-bottom);
    }
}