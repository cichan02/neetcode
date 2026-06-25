class Solution {
    private static final Map<Character, Character> PARENTHESES = Map.of(
            '(', ')',
            '[', ']',
            '{', '}'
    );

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (Character c: s.toCharArray()) {
            if (!PARENTHESES.containsKey(c)) {
                if (!stack.isEmpty() && c.equals(PARENTHESES.get(stack.peek()))) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
