class Solution {
    private static final char DELIMETER = '#';

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length())
                .append(DELIMETER)
                .append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            int j = i;
            while (str.charAt(j) != DELIMETER) {
                j++;
            }
            int l = Integer.parseInt(str.substring(i, j));
            res.add(str.substring(j + 1, j + 1 + l));
            i = j + l;
        }
        return res;
    }
}
