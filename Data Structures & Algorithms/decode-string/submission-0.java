class Solution {
    private int i;

    public String decodeString(final String s) {
        this.i = 0;

        return helper(s);
    }

    private String helper(final CharSequence s) {
        StringBuilder res = new StringBuilder();
        int k = 0;
        for (;i < s.length(); i++) {
            Character boxed = s.charAt(i);

            switch (boxed) {
                case Character c when Character.isDigit(c) -> k = k * 10 + (c - '0');
                case Character c when c == '[' -> {
                    i++;
                    String subRes = helper(s);
                    while (k-- > 0) {
                        res.append(subRes);
                    }
                    k = 0;
                }
                case Character c when c == ']' -> {
                    return res.toString();
                }
                default -> res.append(boxed);
            } 
        }
        return res.toString();
    }
}