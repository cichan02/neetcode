class MedianFinder {
    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;

    public MedianFinder() {
        max = new PriorityQueue(Comparator.reverseOrder());
        min = new PriorityQueue();
    }
    
    public void addNum(int num) {
        if (!min.isEmpty() && num > min.peek()) {
            min.add(num);
        } else {
            max.add(num);
        }

        if (min.size() - max.size() > 1) {
            max.add(min.poll());
        }

        if (max.size() - min.size() > 1) {
            min.add(max.poll());
        }
    }
    
    public double findMedian() {
        if (max.size() > min.size()) {
            return max.peek();
        } else if (min.size() > max.size()) {
            return min.peek();
        } else {
            return (max.peek() + min.peek()) / 2.0;
        }
    }
}
