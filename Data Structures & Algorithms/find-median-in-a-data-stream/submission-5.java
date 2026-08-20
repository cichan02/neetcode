class MedianFinder {
    private final PriorityQueue<Integer> minQ;
    private final PriorityQueue<Integer> maxQ;

    public MedianFinder() {
        this.minQ = new PriorityQueue<>();
        this.maxQ = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum(int num) {
        if (!minQ.isEmpty() && num >= minQ.peek()) {
            minQ.offer(num);
        } else {
            maxQ.offer(num);
        }

        if (maxQ.size() - minQ.size() > 1) {
            minQ.offer(maxQ.remove());
        }

        if (minQ.size() - maxQ.size() > 1) {
            maxQ.offer(minQ.remove());
        }
    }

    public double findMedian() {
        if (maxQ.size() - minQ.size() == 1) {
            return maxQ.peek();
        } else if (minQ.size() - maxQ.size() == 1) {
            return minQ.peek();
        } else {
            return (Optional.ofNullable(maxQ.peek()).orElse(0) +
                    Optional.ofNullable(minQ.peek()).orElse(0)) / 2.0;
        }
    }
}
