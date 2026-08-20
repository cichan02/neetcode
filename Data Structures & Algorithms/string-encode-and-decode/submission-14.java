class Solution {
    private static final char DELIMITER = '#';

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str: strs) {
            sb.append(str.length())
                    .append(DELIMITER)
                    .append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            StringBuilder sb = new StringBuilder();
            while (i < str.length() && str.charAt(i) != DELIMITER) {
                sb.append(str.charAt(i++));
            }
            int len = Integer.parseInt(sb.toString());
            decoded.add(str.substring(i+1, i+1+len));
            i += len;
        }
        return decoded;
    }
}
