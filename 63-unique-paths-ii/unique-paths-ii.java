class Solution {
    int[][] t;
    public int uniquePathsWithObstacles(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        t = new int[m][n];
        boolean flag = true;
        for(int i=0;i<n;i++){
            if(arr[0][i]==1) flag = false;
            if(flag) t[0][i]=1;
            else t[0][i]=0;
        }
        flag = true;
        for(int i=0;i<m;i++){
            if(arr[i][0]==1) flag = false;
            if(flag) t[i][0]=1;
            else t[i][0]=0;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(arr[i][j]==1) t[i][j]=0;
                else t[i][j] = t[i-1][j]+t[i][j-1];
            }
        }
        return t[m-1][n-1];
    }
}