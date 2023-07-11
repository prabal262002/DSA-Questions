class Solution {
    public List<List<String>> partition(String s) {
        ArrayList<List<String>> ans = new ArrayList<>();
        ArrayList<String> ds = new ArrayList<>();
        rcrsn(s,0,ans,ds);
        return ans;
    }
    public void rcrsn(String s,int in,ArrayList<List<String>> ans, ArrayList<String> ds){
        if(in==s.length()){
            ans.add(new ArrayList<String>(ds));
            return ;
        }
        for(int i=in;i<s.length();i++){
            if(isPalindrome(s,in,i)){
                ds.add(s.substring(in,i+1));
                rcrsn(s,i+1,ans,ds);
                ds.remove(ds.size()-1);
            }
        }
    }
    public boolean isPalindrome(String S, int s, int e){
        while(s<e){
            if(S.charAt(s)!=S.charAt(e)) return false;
            s++;e--;
        }
        return true;
    }
}