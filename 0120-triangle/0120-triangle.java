class Solution {
    int[][] t;
    public int minimumTotal(List<List<Integer>> tr) {
        int n = tr.size()-1;
        t = new int[n+1][n+1];
        for(int[] a:t){
            Arrays.fill(a,-1);
        }
        return leet(tr,0,0,n);
    }
    
    public int leet(List<List<Integer>> tr,int i,int j,int n){
        if(i>n) return 0;
        if(j>i) return 0;
        if(t[i][j]!=-1) return t[i][j];
        int down = leet(tr,i+1,j,n);
        int right = leet(tr,i+1,j+1,n);
        int ans = Math.min(down,right)+tr.get(i).get(j);
        t[i][j] = ans;
        return ans;
    }
}