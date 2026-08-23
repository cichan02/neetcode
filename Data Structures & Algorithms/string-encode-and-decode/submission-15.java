class Solution {
    private static final char DELIMITER = '#';

    public String encode(final List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s: strs) {
            sb.append(s.length())
                .append(DELIMITER)
                .append(s);
        }
        return sb.toString();
    }

    public List<String> decode(final String str) {
        final List<String> decoded = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            StringBuilder sb = new StringBuilder();
            while (str.charAt(i) != DELIMITER) {
                sb.append(str.charAt(i++));
            }
            int len = Integer.parseInt(sb.toString());
            decoded.add(str.substring(i+1, i+1+len));
            i += len;
        }
        return List.copyOf(decoded);
    }
}
