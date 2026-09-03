class MinStack {
    private final Deque<Long> deq;

    private long min;
    
    public MinStack() {
        this.deq = new ArrayDeque<>();
        this.min = Long.MAX_VALUE;
    }
    
    public void push(int val) {
        if (deq.isEmpty()) {
            deq.push(0L);
            this.min = val;
            return;
        }

        deq.push(val - min);
        if (val - min < 0) {
            this.min = val;
        }
    }
    
    public void pop() {
        long pop = deq.pop();

        if (pop < 0) {
            this.min -= pop;
        }
    }
    
    public int top() {
        long peek = deq.getFirst();
        
        if (peek > 0) {
            return Math.toIntExact(this.min + peek);
        } else {
            return Math.toIntExact(this.min);
        }
    }
    
    public int getMin() {
        return Math.toIntExact(this.min);
    }
}
