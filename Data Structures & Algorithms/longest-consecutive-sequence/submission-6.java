class Solution {
    record Pair(int length, boolean flag) {}

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        Map<Integer, Pair> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, new Pair(1, false));
        }

        int longest = 1;
        for (int j: nums) {
            int num = j;
            Pair p = map.get(num);
            if (p.flag) {
                continue;
            }
            map.put(num, new Pair(1, true));

            boolean b = true;
            while (b) {
                if (map.containsKey(num + 1)) {
                    int len = map.get(num).length + 1;
                    if (len > longest) {
                        longest = len;
                    }
                    map.put(num + 1, new Pair(len, true));
                    num++;
                } else {
                    b = false;
                }
            }
        }
        return longest;
    }
}
