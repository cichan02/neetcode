// max 3, 2, 1
// min 7, 8, 9

class MedianFinder {
    private final Queue<Integer> max;
    private final Queue<Integer> min;

    public MedianFinder() {
        this.max = new PriorityQueue(Comparator.reverseOrder());
        this.min = new PriorityQueue();
    }
    
    public void addNum(int num) {
        if (!min.isEmpty() && num > min.peek()) {
            min.offer(num);
        } else {
            max.offer(num);
        }

        if (min.size() - max.size() > 1) {
            max.offer(min.poll());
        }
        
        if (max.size() - min.size() > 1) {
            min.offer(max.poll());
        }
    }
    
    public double findMedian() {
        if (min.size() > max.size()) {
            return min.peek();
        } else if (max.size() > min.size()) {
            return max.peek();
        } else {
            return (min.peek() + max.peek()) / 2.0;
        }
    }
}
