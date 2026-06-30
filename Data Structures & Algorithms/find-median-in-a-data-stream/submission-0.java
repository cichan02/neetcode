class MedianFinder {
    private List<Integer> list;

    public MedianFinder() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        list.add(num);
        list.sort(Comparator.naturalOrder());
    }

    public double findMedian() {
        if (list.size() % 2 == 0) {
            int midL =  list.size() / 2 - 1;
            int midR =  list.size() / 2;
            return (list.get(midL) + list.get(midR)) / 2.0;
        } else {
            int mid = list.size() / 2;
            return list.get(mid);
        }
    }
}
