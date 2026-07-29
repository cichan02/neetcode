class WordDictionary {
    private final Node root;

    public WordDictionary() {
        this.root = new Node();
    }

    public void addWord(String word) {
        Node cur = root;
        for (char c: word.toCharArray()) {
            cur.children.putIfAbsent(c, new Node());
            cur = cur.children.get(c);
        }
        cur.isTerminal = true;
    }

    public boolean search(String word) {
        return search(this.root, 0, word);
    }
    
    private boolean search(Node node, int p, String word) {
        Node cur = node;
        for (int i = p; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (Node child: cur.children.values()) {
                    if (search(child, i + 1, word)) {
                        return true;
                    }
                }
                return false;
            } else { 
                if (!cur.children.containsKey(c)) {
                    return false;
                }
                cur = cur.children.get(c);
            }
        }
        return cur.isTerminal;
    } 

    private static final class Node {
        private Map<Character, Node> children;
        private boolean isTerminal;

        public Node() {
            this.children= HashMap.newHashMap(26);
            this.isTerminal = false;
        }
    }
}
