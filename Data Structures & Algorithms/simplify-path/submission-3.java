class Solution {
    private static final String DELIMITER = "/";

    public String simplifyPath(String path) {
        Deque<CharSequence> deq = new LinkedList<>();

        for (String dir: path.split(DELIMITER)) {
            switch(dir) {
                case "", "." -> { }
                case ".." -> deq.pollFirst();
                default -> deq.offerFirst(dir);
            }
        }

        return DELIMITER + String.join(DELIMITER, deq.reversed());
    }
}