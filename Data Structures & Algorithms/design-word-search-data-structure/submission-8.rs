struct WordDictionary {
    store: Vec<String>,
}

impl WordDictionary {
    fn new() -> Self {
        WordDictionary { store: Vec::new() }
    }

    fn add_word(&mut self, word: String) {
        self.store.push(word);
    }

    fn search(&self, word: String) -> bool {
        let word_bytes = word.as_bytes();
        for w in &self.store {
            let w_bytes = w.as_bytes();
            if w_bytes.len() != word_bytes.len() {
                continue;
            }
            let mut i = 0;
            while i < w_bytes.len() {
                if w_bytes[i] == word_bytes[i] || word_bytes[i] == b'.' {
                    i += 1;
                } else {
                    break;
                }
            }
            if i == w_bytes.len() {
                return true;
            }
        }
        false
    }
}