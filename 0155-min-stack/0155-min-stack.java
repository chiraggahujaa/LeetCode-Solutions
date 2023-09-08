class Pair{
    int i, val;
    Pair(int i, int val){
        this.i = i;
        this.val = val;
    }
}
class MinStack {
    Stack<Pair> s, ss;
    public MinStack() {
        this.s = new Stack<>();
        this.ss = new Stack<>();
    }
    
    public void push(int val) {
        int i = s.size();

        s.push(new Pair(i, val));
        if(ss.isEmpty() || ss.peek().val > val){
            ss.push(new Pair(i, val));
        }
    }
    
    public void pop() {
        if(s.peek().i == ss.peek().i)
            ss.pop();
        s.pop();
    }
    
    public int top() {
        return s.peek().val;
    }
    
    public int getMin() {
        return ss.peek().val;
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