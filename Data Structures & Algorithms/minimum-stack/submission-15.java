class MinStack {
    private final Deque<Long> deq;

    private long min;

    public MinStack() {
        this.deq = new ArrayDeque<>();
        this.min = Long.MAX_VALUE;
    }

    public void push(int val) {
        if (deq.isEmpty()) {
            this.deq.push(0L);
            this.min = val;
            return;
        }
        
        deq.push(val - min);
        if (val < min) {
            this.min = val;
        }
    }

    public void pop() {
        long pop = deq.removeFirst();

        if (pop < 0) {
            this.min = this.min - pop;
        }
    }

    public int top() {
        long top = deq.getFirst();
        if (top > 0) {
            return Math.toIntExact(this.min + top);
        } else {
            return Math.toIntExact(this.min);
        }
    }

    public int getMin() {
        return Math.toIntExact(this.min);
    }
}
