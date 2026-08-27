class PrefixTree {
    private static final int K = 26;

    private final Node root;

    public PrefixTree() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node cur = this.root;
        for (char c: word.toCharArray()) {
            int index = c - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new Node();
            }
            cur = cur.children[index];
        }
        cur.isTerminal = true;
    }

    public boolean search(String word) {
        Node cur = this.root;
        for (char c: word.toCharArray()) {
            int index = c - 'a';
            if (cur.children[index] == null) {
                return false;
            }
            cur = cur.children[index];
        }
        return cur.isTerminal;
    }

    public boolean startsWith(String prefix) {
        Node cur = this.root;
        for (char c: prefix.toCharArray()) {
            int index = c - 'a';
            if (cur.children[index] == null) {
                return false;
            }
            cur = cur.children[index];
        }
        return true;
    }

    private static class Node {
        private final Node[] children;

        private boolean isTerminal;

        public Node() {
            this.children = new Node[26];
            this.isTerminal = false;
        }
    }
}
