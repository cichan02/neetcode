class Solution {
    private static final Map<Character, Character> openToClose = Map.of(
        '(', ')',
        '{', '}',
        '[', ']'
    );

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c: s.toCharArray()) {
            if (openToClose.containsKey(c)) {
                stack.push(c);
                continue;
            }
            if (!stack.isEmpty() && c == openToClose.get(stack.peek())) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
