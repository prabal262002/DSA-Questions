class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int lo = 0,hi = m*n-1;
        while(lo<=hi){
            int mid = (lo+hi)/2;
            int i = mid/m,j = mid%m;
            if(matrix[i][j]==target) return true;
            else if(matrix[i][j]>target) hi = mid-1;
            else lo = mid+1;
        }
        return false;
    }
}