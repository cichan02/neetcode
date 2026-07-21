class Solution {
    public static class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int p) {
            if (parent[p] != p) {
                parent[p] = find(parent[p]);
            }
            return parent[p];
        }

        private void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            if (rank[rootP] < rank[rootQ]) {
                parent[rootP] = rootQ;
                rank[rootQ] += rank[rootP];
            } else {
                parent[rootQ] = rootP;
                rank[rootP] += rank[rootQ];
            }
        }

        private int longest() {
            int longest = 0;
            for (int j : rank) {
                longest = Math.max(longest, j);
            }
            return longest;
        }
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numToIndex.put(nums[i], i);
        }

        UnionFind uf = new UnionFind(nums.length);

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (numToIndex.get(num) != i) {
                continue;
            }
            
            if (numToIndex.containsKey(num - 1)) {
                int j = numToIndex.get(num - 1);
                uf.union(i, j);
            }
        }

        return uf.longest();
    }
}
