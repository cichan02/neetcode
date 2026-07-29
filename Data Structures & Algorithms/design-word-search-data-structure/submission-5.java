class WordDictionary {
    private static final int K = 26;
    
    private final Node root;

    public WordDictionary() {
        this.root = new Node();
    }

    public void addWord(String word) {
        Node cur = root;
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
        return search(root, 0, word);
    }

    private boolean search(Node node , int p, String word) {
        Node cur = node;
       for (int i = p; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (Node child: cur.children) {
                    if (child != null && search(child, i + 1, word )) {
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

    private static final class Node {
        private Node[] children;
        private boolean isTerminal;

        public Node() {
            this.children = new Node[K];
            this.isTerminal = false;
        }
    }
}
