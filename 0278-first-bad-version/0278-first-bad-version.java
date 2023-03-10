/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long lo=1,hi=n;
        int ans=n;
        while(lo<=hi){
            long mid = (lo+hi)/2;
            if(isBadVersion((int)mid)) {hi = mid-1;ans = (int)mid;}
            else lo = mid+1;
        }
        return ans;
    }
}