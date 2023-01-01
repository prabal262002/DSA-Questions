class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> m = new HashMap<>();
        HashMap<String,Character> n = new HashMap<>();
        String[] str = s.split(" ");
        if(str.length!=pattern.length()) return false;
        for(int i=0;i<pattern.length();i++){
            char t = pattern.charAt(i);
            if(!m.containsKey(t) && !n.containsKey(str[i])) {
                m.put(t,str[i]);
                n.put(str[i],t);}
            else {
                if(!str[i].equals(m.get(t)) || t!=n.get(str[i])) return false;
            }
        }
        return true;
    }
}