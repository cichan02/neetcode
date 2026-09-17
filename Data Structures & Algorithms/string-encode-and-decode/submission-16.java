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
        List<String> tmp = new ArrayList<>();
        for (int i = 0; i < str.length(); ) {
            int j = i;
            while (DEL != str.charAt(j)) {
                j++;
            }
            int len = Integer.parseInt(str.substring(i, j++));
            tmp.add(str.substring(j, j + len));
            i = j + len;
        }
        return List.copyOf(tmp);
    }
}
