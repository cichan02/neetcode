class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        Map<Character, Integer> freqT = HashMap.newHashMap(t.length());
        for (char c : t.toCharArray()) {
            freqT.put(c, freqT.getOrDefault(c, 0) + 1);
        }

        //brute force
        String res = "";
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            Map<Character, Integer> copy = new HashMap<>(freqT);
            while (!copy.isEmpty() && j < s.length()) {
                if (!copy.containsKey(s.charAt(j))) {
                    j++;
                    continue;
                }

                int f = copy.get(s.charAt(j));
                if (f == 1) {
                    copy.remove(s.charAt(j));
                } else {
                    copy.put(s.charAt(j), f - 1);
                }
                j++;
            }

            if (copy.isEmpty() && j - i < min) {
                min = j - i;
                res = s.substring(i, j);
            }
        }

        return res;
    }
}
