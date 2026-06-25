class Solution {
    private static final Map<Character, Character> PARENTHESES = Map.of(
            '(', ')',
            '[', ']',
            '{', '}'
    );

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (Character c: s.toCharArray()) {
            if (!PARENTHESES.containsKey(c) && !stack.isEmpty()) {
                Character back = PARENTHESES.get(stack.peek());
                if (c.equals(back)) {
                    stack.pop();
                    continue;
                } else {
                    return false;
                }
            }
            stack.push(c);
        }
        return stack.isEmpty();
    }
}
