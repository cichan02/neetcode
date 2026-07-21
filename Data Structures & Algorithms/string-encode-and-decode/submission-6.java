class Solution {
    private static final short DELIMETER = 257;
    private static final byte ZERO = 0;

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();

        if (strs.isEmpty()) {
            return null;
        }

        for (int i = 0; i < strs.size() - 1; i++) {
            String str = strs.get(i);
            for (int j = 0; j < strs.get(i).length(); j++) {
                short s = (short) str.charAt(j);
                if (s < 10) {
                    encoded.append(ZERO).append(ZERO).append(s);
                } else if (s < 100) {
                    encoded.append(ZERO).append(s);
                } else {
                    encoded.append(s);
                }
            }
            encoded.append(DELIMETER);
        }
        String str = strs.get(strs.size() - 1);
        for (int j = 0; j < str.length(); j++) {
            short s = (short) str.charAt(j);
            if (s < 10) {
                encoded.append(ZERO).append(ZERO).append(s);
            } else if (s < 100) {
                encoded.append(ZERO).append(s);
            } else {
                encoded.append(s);
            }
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();

         if (str == null) {
            return decoded;
         }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i += 3) {
            short asciiNumber = Short.parseShort(str.substring(i, i+3));
            if (asciiNumber != DELIMETER) {
                char ch = (char) asciiNumber;
                sb.append(ch);
            } else {
                decoded.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        decoded.add(sb.toString());
        return decoded;
    }
}
