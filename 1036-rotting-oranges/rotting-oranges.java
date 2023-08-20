public class Pair{
    int i;
    int j;
    int time;
    Pair(int i,int j,int time){
        this.i = i;
        this.j = j;
        this.time = time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n= grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        int countFresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2) {
                    vis[i][j]=2;
                    q.offer(new Pair(i,j,0));
                }
                else if(grid[i][j]==1) countFresh++;
            }
        }
        int[] row = {-1,0,+1,0};
        int[] col = {0,+1,0,-1};
        int cnt=0,time=0;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int r  = p.i;
            int c = p.j;
            int t = p.time;
            time = Math.max(time,t);
            for(int i =0;i<4;i++){
                int nrow = r + row[i];
                int ncol = c + col[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0
                && grid[nrow][ncol]==1){
                    q.offer(new Pair(nrow,ncol,t+1));
                    vis[nrow][ncol]=2;
                    cnt++;
                }
            }
        }
        if(cnt!= countFresh) return -1;
        return time;

    }
}