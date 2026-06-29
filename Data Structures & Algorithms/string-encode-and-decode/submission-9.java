class Solution {
    private static final char DELIMETER = '#';

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(DELIMETER)
                    .append(encodeLength(str.length()))
                    .append(str);
        }
        return sb.toString();
    }

    public String encodeLength(int length) {
        if (length < 10) {
            return "00" + length;
        }

        if (length < 100) {
            return "0" + length;
        }

        return String.valueOf(length);
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            if (curr == DELIMETER) {
                int length = decodeLength(str.substring(i + 1, i + 4));
                res.add(str.substring(i + 4, i + 4 + length));
                i = i + 4 + length - 1;
            }
        }
        return res;
    }

    public int decodeLength(String length) {
        if (length.equals("000")) {
            return 0;
        }
        int i = 0;
        while (length.charAt(i) == '0') {
            i++;
        }
        return Integer.parseInt(length.substring(i));
    }
}
