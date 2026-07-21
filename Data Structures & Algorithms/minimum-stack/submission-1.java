class MinStack {
    private final Deque<Integer> deque;
    private final Deque<Integer> minDeq;

    public MinStack() {
        this.deque = new ArrayDeque<>();
        this.minDeq = new ArrayDeque<>();
    }

    public void push(int val) {
        this.deque.push(val);
        if (this.minDeq.isEmpty() || val <= this.minDeq.peek()) {
            this.minDeq.push(val);
        }
    }

    public void pop() {
        if (this.deque.isEmpty()) return;
        int top = this.deque.pop();
        if (top == this.minDeq.peek()) {
            this.minDeq.pop();
        }
    }

    public int top() {
        return this.deque.peek();
    }

    public int getMin() {
        return this.minDeq.peek();
    }
}
