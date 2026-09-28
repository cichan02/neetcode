// min: 7, 8, 9
// max: 3, 2, 1
public class MedianFinder {
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
        return switch(Integer.signum(min.size() - max.size())) {
            case 1 -> min.peek();
            case -1 -> max.peek();
            default -> (Optional.ofNullable(max.peek()).orElse(0) + Optional.ofNullable(min.peek()).orElse(0)) / 2.0;
        };
    }
}
