public class WordDictionary {
    private static final char ANY_CHAR = '.';

    private final Node root;

    public WordDictionary() {
        this.root = new Node();
    }

    public void addWord(String word) {
        Node cur = root;
        for(char c: word.toCharArray()) {
            int i = c - 'a';
            if (cur.children[i] == null) {
                cur.children[i] = new Node();
            }
            cur = cur.children[i];
        }
        cur.isTerminal = true;
    }

    public boolean search(String word) {
        return this.search(0, word, root);
    }

    private boolean search(int i, String word, Node node) {
        Node cur = node;
        for (int j = i; j < word.length(); j++) {
            char c = word.charAt(j);
            if (c == ANY_CHAR) {
                for (Node child: cur.children) {
                    if (child != null && search(j+1, word, child)) {
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

    private static class Node {
        private static final int ALPHABET_SIZE = 26;

        private final Node[] children;
        private boolean isTerminal;

        private Node() {
            this.children = new Node[ALPHABET_SIZE];
            this.isTerminal = false;
        }
    }
}
