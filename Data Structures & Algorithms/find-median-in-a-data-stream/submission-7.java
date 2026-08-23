// minQ = 6, 7, 8
// maxQ = 3, 2, 1

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

        if (minQ.size() - maxQ.size() > 1) {
            maxQ.offer(minQ.poll());
        }

        if (maxQ.size() - minQ.size() > 1) {
            minQ.offer(maxQ.poll());
        }
    }
    
    public double findMedian() {
        if (minQ.size() - maxQ.size() == 1) {
            return minQ.peek();
        } else if (maxQ.size() - minQ.size() == 1) {
            return maxQ.peek();
        } else {
            int num1 = Optional.ofNullable(minQ.peek()).orElse(0);
            int num2 = Optional.ofNullable(maxQ.peek()).orElse(0);
            return (num1 + num2) / 2.0;
        }
    }
}
