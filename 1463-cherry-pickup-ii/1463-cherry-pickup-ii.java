class Solution {
    public int cherryPickup(int[][] grid) {
        return get(grid, 0, 0, grid[0].length - 1, new Integer[grid.length][grid[0].length][grid[0].length]);
    }
    private int get(int[][] grid, int r, int c1, int c2, Integer[][][] dp) {
    if(r == grid.length || c1 < 0 || c1 >= grid[0].length || c2 < 0 || c2 >= grid[0].   length || c1 > c2) 
    return 0;
    if(dp[r][c1][c2] != null) 
        return dp[r][c1][c2];
    int max = 0;
    for(int i = -1; i <= 1; i++) 
        for(int j = -1; j <= 1; j++) 
            max = Math.max(max, get(grid, r + 1, c1 + i, c2 + j, dp));
    
    return dp[r][c1][c2] = max + grid[r][c1] + (c1 == c2 ? 0 : grid[r][c2]);
    }
}