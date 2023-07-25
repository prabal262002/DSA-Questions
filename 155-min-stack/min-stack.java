class Pair {
    int x, y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class MinStack {

    Stack<Pair> stck;
    public MinStack() {
        stck = new Stack<>();
    }
    
    public void push(int val) {
        int min=val;
        if(!stck.isEmpty()){
            min = Math.min(min,stck.peek().y);
        }
        stck.push(new Pair(val,min));
    }
    
    public void pop() {
        stck.pop();
    }
    
    public int top() {
       return stck.peek().x;
    }
    
    public int getMin() {
        return stck.peek().y;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */