class Solution {
    private int i;

    public String decodeString(String s) {
        this.i = 0;

        return decode(s).toString();
    }

    private CharSequence decode(CharSequence s) {
        StringBuilder sb = new StringBuilder();
        int k = 0;
        for (; i < s.length(); i++) {
            char c = s.charAt(i);

            switch(c) {
                case '0','1','2','3','4','5','6','7','8','9' -> k = k * 10 + (c - '0');
                case '[' -> {
                    i++;
                    CharSequence t = decode(s);
                    while (k-- > 0) {
                        sb.append(t);
                    }
                    k = 0;
                }
                case ']' -> {
                    return sb;
                }
                default -> sb.append(c);
            }
        }
        return sb;
    }
}