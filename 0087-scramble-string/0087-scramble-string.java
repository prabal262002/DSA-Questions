class Solution {
    HashMap<String,Boolean> m = new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        if(s1.equals(s2)) return true;
        if(s1.length()<=1 || s2.length()<=1) return false;
        if(m.containsKey(s1+" "+s2)) return m.get(s1+" "+s2);
        int n = s1.length();
        boolean flag = false;
        for(int i=1;i<=n-1;i++ ){
            if((isScramble(s1.substring(0,i),s2.substring(0,i)) && isScramble(s1.substring(i),s2.substring(i)))
            || (isScramble(s1.substring(0,i),s2.substring(n-i)) && isScramble(s1.substring(i),s2.substring(0,n-i)))) {
                flag = true;
                break;
            }
        }
        m.put(s1+" "+s2,flag);
        return flag;
    }
}