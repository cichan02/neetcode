class MinStack {
    private Deque<Integer> deq;
    private Deque<Integer> minDeq;

    public MinStack() {
        this.deq = new ArrayDeque<>();
        this.minDeq = new ArrayDeque<>();
    }
    
    public void push(int val) {
        deq.offerFirst(val);
        final int min;
        if (!minDeq.isEmpty()) {
            min = Math.min(val, minDeq.peekFirst());
        } else {
            min = val;
        }
        minDeq.offerFirst(min);
    }
    
    public void pop() {
        deq.pollFirst();
        minDeq.pollFirst();
    }
    
    public int top() {
        return deq.getFirst();
    }
    
    public int getMin() {
        return minDeq.getFirst();
    }
}
