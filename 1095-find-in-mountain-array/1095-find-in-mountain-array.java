/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int index = peak(mountainArr);
        int lo = 0,hi = index;
        int ans = Search(mountainArr,target,lo,hi);
        if(ans!=-1) return ans;
        lo = index+1;
        return Searcht(mountainArr,target,lo,mountainArr.length()-1);
    }
    static int Search(MountainArray mountainArr, int target, int lo, int hi){
        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(mountainArr.get(mid)==target) return mid;
            else if(mountainArr.get(mid)>target) hi = mid-1;
            else lo = mid+1;
        }
        return -1;
    }
    static int Searcht(MountainArray mountainArr, int target, int lo, int hi){
        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(mountainArr.get(mid)==target) return mid;
            else if(mountainArr.get(mid)<target) hi = mid-1;
            else lo = mid+1;
        }
        return -1;
    }
    public static int peak(MountainArray mountainArr) {
        int lo =0,hi = mountainArr.length()-1;
        int max = 0;
        while(lo<hi){
            int mid = (lo+hi)/2;
            //if(arr[mid+1]<arr[mid] && arr[mid-1]<arr[mid]) return mid;
            // ^^Above line can be ommitted.
            if(mountainArr.get(mid+1)<mountainArr.get(mid)) hi = mid; // {\}
            else lo = mid+1;
        }
        return lo;
    }
}