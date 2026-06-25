class Solution {
    private static final Map<Character, Character> PARENTHESES = Map.of(
            '(', ')',
            '[', ']',
            '{', '}'
    );

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (Character c: s.toCharArray()) {
            if (PARENTHESES.containsKey(c)) {
                stack.push(c);
                continue;
            }
            
            if (!stack.isEmpty() && PARENTHESES.get(stack.peek()).equals(c)) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
