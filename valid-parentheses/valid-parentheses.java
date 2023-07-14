class Solution {
    public boolean isValid(String s) {
        Stack<Character> stck = new Stack<>();
        for(int a=0;a<s.length();a++){
            char p = s.charAt(a);
            if(stck.isEmpty()) stck.push(p);
            else
                switch(p){
                    case ')' -> {
                                if(stck.peek()=='(')
                                    stck.pop();
                                else stck.push(p);
                                }
                    case ']' -> {
                                if(stck.peek()=='[')
                                    stck.pop();
                                else stck.push(p);
                                }
                    case '}' -> {
                                if(stck.peek()=='{')
                                    stck.pop();
                                else stck.push(p);
                                }
                    default ->  stck.push(p);            
                }
        }
        return stck.isEmpty();
    }
}