class Solution {
    private static final Map<Character, Character> P = Map.of(
        '(', ')',
        '{', '}',
        '[', ']'
    );

    public boolean isValid(String s) {
        Deque<Character> deq = new LinkedList<>();
        for (Character c: s.toCharArray()) {
            if (!deq.isEmpty() && c.equals(P.get(deq.peek()))) {
                deq.pop();
            } else {
                deq.push(c);
            }
        }
        return deq.isEmpty();
    }
}
