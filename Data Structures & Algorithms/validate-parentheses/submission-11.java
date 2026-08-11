class Solution {
    private static final Map<Character, Character> PARENTHESES = Map.of(
        '(', ')',
        '{', '}',
        '[', ']'
    );

    public boolean isValid(String s) {
        Deque<Character> deq = new ArrayDeque<>();
        for(char c: s.toCharArray()) {
            if (PARENTHESES.containsKey(c)) {
                deq.push(c);
                continue;
            }
            
            if (!deq.isEmpty() && c == PARENTHESES.get(deq.peek())) {
                deq.pop();
            } else {
                return false;
            }
        }
        return deq.isEmpty();
    }
}
