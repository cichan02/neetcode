class Solution {
    private static final Map<Character, Character> PARENTHESES = Map.of(
            ')', '(',
            '}', '{',
            ']', '['
    );

    public boolean isValid(String s) {
        Deque<Character> deq = new ArrayDeque<>();
        for (char c: s.toCharArray()) {
            if (PARENTHESES.containsKey(c)) {
                if (!deq.isEmpty() && Objects.equals(PARENTHESES.get(c), deq.peek())) {
                    deq.pop();
                } else {
                    return false;
                }
            } else {
                deq.push(c);
            }
        }
        return deq.isEmpty();
    }
}
