class MinStack {
    Stack<Long> s;
    long min;
    public MinStack() {
        this.s = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        long l = (long) val;
        if(s.isEmpty()){
            s.push(l);
            min = l;
        }
        else{
            if(l < min){
                s.push(2*l - min);
                min = l;
            }
            else
                s.push(l);
        }
    }
    
    public void pop() {
        if(s.peek() < min)
            min = 2 * min - s.pop();
        else
            s.pop();
    }
    
    public int top() {
        long top = s.peek();
        if (top < min) {
            return (int) min;
        } else {
            return (int) top;
        }
    }
    
    public int getMin() {
        return (int)min;
    }
}