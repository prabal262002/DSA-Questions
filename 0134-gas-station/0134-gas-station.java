class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        long sum=0,sum2=0;
        int ind=0;
        for(int i=0;i<gas.length;i++){
            sum+=gas[i]-cost[i];
            sum2+=gas[i]-cost[i];
            if(sum2<0){
                sum2=0;
                ind=i+1;
            }
        }
        return sum<0?-1:ind;
    }
}