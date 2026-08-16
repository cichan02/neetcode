class UnionFind {
    private final int[] parent;
    private final int[] rank;

    private int maxRank;

    public UnionFind(int n) {
        this.parent = new int[n];
        this.rank = new int[n];
        this.maxRank = 0;
        for (int i = 0; i < n; i++) {
            this.parent[i] = i;
            this.rank[i] = 1;
            this.maxRank = 1;
        }
    }

    public int find(int p) {
        if (parent[p] != p) {
            parent[p] = find(parent[p]);
        }
        return parent[p];
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        if (rank[rootP] < rank[rootQ]) {
            parent[rootP] = rootQ;
            rank[rootQ] += rank[rootP];
            maxRank = Math.max(maxRank, rank[rootQ]);
        } else {
            parent[rootQ] = rootP;
            rank[rootP] += rank[rootQ];
            maxRank = Math.max(maxRank, rank[rootP]);
        }
    }

    public int getMaxRank() {
        return maxRank;
    }
}

class Solution {
    public int longestConsecutive(int[] nums) {
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

        return uf.getMaxRank();
    }
}
