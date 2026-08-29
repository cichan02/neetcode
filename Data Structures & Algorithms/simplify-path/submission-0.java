class Solution {
    private static final String DELIMITER = "/";
    
    public String simplifyPath(String path) {
        Deque<String> deq = new LinkedList<>();

        for (String dir : path.split(DELIMITER)) {
            switch (dir) {
                case ".." -> deq.pollFirst();
                case "", "." -> { }
                default -> deq.offerFirst(dir);
            }
        }

        return DELIMITER + String.join(DELIMITER, deq.reversed());
    }
}