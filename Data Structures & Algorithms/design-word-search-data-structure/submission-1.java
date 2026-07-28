class WordDictionary {  
    private final Node root;

    public WordDictionary() {
        this.root = new Node();
    }

    public void addWord(String word) {
       Node cur = root;
        for (char c : word.toCharArray()) {
            cur.children.putIfAbsent(c, new Node());
            cur = cur.children.get(c);
        }
        cur.isTerminal = true;
    }

    public boolean search(String word) {
        return search(root, 0, word);
    }

    private boolean search(Node n, int p, String word) {
        Node cur = n;
        for (int i = p; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (Node node: cur.children.values()) {
                    if (search(node, i + 1, word)) {
                        return true;
                    }
                }
                return false;
            } 
            
             if (!cur.children.containsKey(c)) {
                return false;
            }
            cur = cur.children.get(c);
        }
        return cur.isTerminal;
    }

    private static class Node {
        private Map<Character, Node> children;
        private boolean isTerminal;

        public Node() {
            this.children = new HashMap<>();
            this.isTerminal = false;
        }
    }
}
