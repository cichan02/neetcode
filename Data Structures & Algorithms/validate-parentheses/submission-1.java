class Solution {
    private static final Set<Character>  VALID_OPEN_PARENTHESES = Set.of('(', '[', '{');
    private static final Map<Character, Character> PARENTHESES = Map.of(
            '(', ')',
            '[', ']',
            '{', '}'
    );

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (VALID_OPEN_PARENTHESES.contains(c)) {
                stack.push(c);
                continue;
            }

            if (stack.isEmpty() || !PARENTHESES.get(stack.pop()).equals(c)) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
