class Solution {
    public boolean buddyStrings(String s, String goal) {
        int[] arr =new int[26];
        int n = s.length();
        int m = goal.length();
        if(n!=m) return false;
        if(s.equals(goal)){
            for(char ch: s.toCharArray()){
                arr[ch-'a']++;
                if(arr[ch-'a']==2) return true; 
            }
            return false;
        }
        ArrayList<Integer> l = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(s.charAt(i)!=goal.charAt(i))
                l.add(i);
            if(l.size()>2) return false;
        }
        return (l.size()==2 && s.charAt(l.get(0))==goal.charAt(l.get(1)) &&s.charAt(l.get(1))==goal.charAt(l.get(0)));
    }
}