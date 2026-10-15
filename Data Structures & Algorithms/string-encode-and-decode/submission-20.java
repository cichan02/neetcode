class Solution {
    private static final char DEL = '#';

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s: strs) {
            sb.append(s.length())
                .append(DEL)
                .append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < str.length(); ) {
            int j = i;
            while (j < str.length() && str.charAt(j) != DEL) {
                j++;
            }
            int len = Integer.valueOf(str.substring(i, j++));
            res.add(str.substring(j, j + len));
            i = j + len;
        }
        return res;
    }
}
