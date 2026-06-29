class Solution {
    private static final char DELIMETER = '#';

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str: strs) {
            sb.append(str.length())
                    .append(DELIMETER)
                    .append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != DELIMETER) {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            decoded.add(str.substring(j + 1, j + 1 + length));
            i = j + 1 + length;
        }
        return decoded;
    }
}
