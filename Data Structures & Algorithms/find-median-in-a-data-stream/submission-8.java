// minQ: 6, 7, 8
// maxQ: 3, 2, 1

class MedianFinder {
    private final Queue<Integer> minQ;
    private final Queue<Integer> maxQ;

    public MedianFinder() {
        this.minQ = new PriorityQueue<>();
        this.maxQ = new PriorityQueue<>(Comparator.reverseOrder());
    }
    
    public void addNum(int num) {
        if (!minQ.isEmpty() && num > minQ.peek()) {
            minQ.offer(num);
        } else {
            maxQ.offer(num);
        }

        switch (Integer.signum(maxQ.size() - minQ.size())) {
            case 1 -> minQ.offer(maxQ.poll());
            case -1 -> maxQ.offer(minQ.poll());
        }
    }
    
    public double findMedian() {
            return switch(Integer.signum(minQ.size() - maxQ.size())) {
                case 1 -> minQ.peek();
                case -1 -> maxQ.peek();
            case 0 -> (Optional.ofNullable(maxQ.peek()).orElse(0) + Optional.ofNullable(minQ.peek()).orElse(0)) / 2.0;
            default -> throw new IllegalStateException("Unexpected value: " + Integer.signum(minQ.size() - maxQ.size()));
            };
    }
}
