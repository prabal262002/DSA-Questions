class Solution {
    int[][] t = new int[51][51];
    public int minScoreTriangulation(int[] values) {
        for(int[] a: t){
            Arrays.fill(a,-1);
        }
        int i=0;
        int j=values.length-1;
        return leet(values,i,j);
    }
    public int leet(int[] arr,int i,int j){
        if(i+2>j) return 0;
        if(t[i][j]!=-1){
            return t[i][j];
        }
        int min = Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++){
            int temp = leet(arr,i,k)+leet(arr,k,j)+arr[i]*arr[j]*arr[k];
            min = Math.min(temp,min);
        }
        t[i][j] = min;
        return min;
    }
}