class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        ArrayList<Integer> l = new ArrayList<>();
        int lo=0,r=0;
        while(lo<m && r<n){
            if(nums1[lo]==nums2[r]){
                l.add(nums1[lo++]);
                l.add(nums2[ r++]);
            }
            else if(nums1[lo]<nums2[r])  l.add(nums1[lo++]);
            else                    l.add(nums2[ r++]);
        }
        while(lo<m){l.add(nums1[lo++]);}
        while(r<n){l.add(nums2[r++]);}
        int i=0;
        for(int a:l){
            nums1[i++] = a;
        }
    }
}