class Solution {
    public int minDeletionSize(String[] strs) {
        int count=0;
        for(int i=0;i<strs[0].length();i++){
            for(int j=1;j<strs.length;j++){
                int n = (int)strs[j].charAt(i);
                int p = (int)strs[j-1].charAt(i);
                if(p>n) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}