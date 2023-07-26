
class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int totalDist=0;
        int lo = 1,hi = 10000000;
        int result=-1;
        while(lo<=hi){
            int speed = (lo+hi)/2;
            double currtime = check(dist,hour,speed);
            if(currtime<=hour) {
                result = speed;
                hi = speed-1;}
            else lo = speed+1;
        }
        return result;
    }
    public double check(int[] dist,double hour, int speed){
        double me =0.0;
        int n = dist.length;
        for(int i=0;i<n-1;i++){
            me+= Math.ceil((dist[i]*1.0)/speed);
        }
        me+=(dist[n-1]*1.0)/speed;
        
        return me;
    }
}