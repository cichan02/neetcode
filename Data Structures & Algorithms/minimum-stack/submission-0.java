class MinStack {
    private final Deque<Integer> deque;
    private final PriorityQueue<Integer> queue;

    public MinStack() {
        this.deque = new ArrayDeque<>();
        this.queue = new PriorityQueue<>();
    }

    public void push(int val) {
        this.deque.push(val);
        this.queue.add(val);
    }

    public void pop() {
        int val = this.deque.pop();
        this.queue.remove(val);
    }

    public int top() {
        return this.deque.peek();
    }

    public int getMin() {
        return this.queue.peek();
    }
}
