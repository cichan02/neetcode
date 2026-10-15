struct Node {
    children_indices_in_vec: [usize; 26],
    is_terminal: bool
}

impl Node {
    pub fn new() -> Self {
        Self {
            children_indices_in_vec: [0; 26],
            is_terminal: false
        }
    }

    pub fn children(&self) -> &[usize] {
        &self.children_indices_in_vec
    }

    pub fn children_mut(&mut self) -> &mut [usize] {
        &mut self.children_indices_in_vec
    }
 
    pub fn is_terminal(&self) -> bool {
        self.is_terminal
    }

    pub fn set_terminal(&mut self) {
        self.is_terminal = true;
    }
}

struct PrefixTree {
    nodes: Vec<Node>
}

impl PrefixTree {
    pub fn new() -> Self {
        Self {
            nodes: vec![Node::new()]
        }
    }

    pub fn insert(&mut self, word: String) {
        let mut cur_i: usize = 0;
        for c in word.bytes() {
            let i1: usize = (c - b'a') as usize;
            if self.nodes[cur_i].children()[i1] == 0 {
                self.nodes[cur_i].children_mut()[i1] = self.nodes.len();
                self.nodes.push(Node::new());
            }
            cur_i = self.nodes[cur_i].children()[i1];
        }
        self.nodes[cur_i].set_terminal();
    } 

    pub fn search(&self, word: String) -> bool {
        let mut cur: &Node = self.nodes.first().unwrap();
        for c in word.bytes() {
            let i1: usize = (c - b'a') as usize;
            let i2: usize = cur.children()[i1];
            if i2 == 0 {
                return false;
            }
            cur = self.nodes.get(i2).unwrap();
        }
        cur.is_terminal()
    }

    pub fn starts_with(&self, prefix: String) -> bool {
        let mut cur: &Node = self.nodes.first().unwrap();
        for c in prefix.bytes() {
            let i1: usize = (c - b'a') as usize;
            let i2: usize = cur.children()[i1];
            if i2 == 0 {
                return false;
            }
            cur = self.nodes.get(i2).unwrap();
        }
        true
    }
}