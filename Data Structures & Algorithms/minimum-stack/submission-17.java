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
        if (val < min) {
            this.min = val;
        }
    }
    
    public void pop() {
        long first = deq.pop();
        if (first < 0) {
            this.min -= first;
        }
    }
    
    public int top() {
        long first = deq.getFirst();
        if (first > 0) {
            return Math.toIntExact(this.min + first);
        } else {
            return Math.toIntExact(this.min);
        }
    }
    
    public int getMin() {
        return Math.toIntExact(this.min);
    }
}
