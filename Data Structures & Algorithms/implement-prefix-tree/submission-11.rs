struct Node {
    children: HashMap<char, Node>,
    is_terminal: bool,
}

impl Node {
    fn new() -> Self {
        Self {
            children: HashMap::new(),
            is_terminal: false,
        }
    }
}

struct PrefixTree {
    root: Node,
}

impl PrefixTree {
    fn new() -> Self {
        Self { 
            root: Node::new()
        }
    }

    fn insert(&mut self, word: String) {
        let mut cur = &mut self.root;
        for c in word.chars() {
            cur = cur.children.entry(c).or_insert_with(Node::new);
        }
        cur.is_terminal = true;
    }

    fn search(&self, word: String) -> bool {
        let mut cur = &self.root;
        for c in word.chars() {
            match cur.children.get(&c) {
                Some(node) => cur = node,
                None => return false,
            }
        }
        cur.is_terminal
    }

    fn starts_with(&self, prefix: String) -> bool {
        let mut cur = &self.root;
        for c in prefix.chars() {
            match cur.children.get(&c) {
                Some(node) => cur = node,
                None => return false,
            }
        }
        true
    }
}