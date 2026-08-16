class WordDictionary {
    private final Node root;

    public WordDictionary() {
        this.root = new Node();
    }

    public void addWord(String word) {
        Node cur = this.root;
        for (char c: word.toCharArray()) {
            int i = c - 'a';
            if (cur.children[i] == null) {
                cur.children[i] = new Node();
            }
            cur = cur.children[i];
        }
        cur.isTerminal = true;
    }

    public boolean search(String word) {
        return search(word, 0, this.root);
    }

    private boolean search(String word, int j, Node node) {
        Node cur = node;
        for (int i = j; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (Node child: cur.children) {
                    if (child != null && search(word, i+1, child)) {
                        return true;
                    }
                }
                return false;
            } else {
                int index = c - 'a';
                if (cur.children[index] == null) {
                    return false;
                }
                cur = cur.children[index];
            }
        }
        return cur.isTerminal;
    }

    class Node {
        private boolean isTerminal;
        private Node[] children;

        public Node() {
            this.isTerminal = false;
            this.children = new Node[26];
        }
    }
}
