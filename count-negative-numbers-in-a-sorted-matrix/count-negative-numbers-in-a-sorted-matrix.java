class Solution {
    public int countNegatives(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]<0) {count+=m-j;break;}
            }
        }
        return count;
    }
}