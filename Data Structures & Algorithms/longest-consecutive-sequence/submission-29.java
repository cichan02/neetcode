class UnionFind {
    private final int[] parent;
    private final int[] rank;
    
    private int longest;

    public UnionFind(int n) {
        this.parent = new int[n];
        this.rank = new int[n];
        this.longest = 1;
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

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        if (rank[rootP] < rank[rootQ]) {
            parent[rootP] = rootQ;
            rank[rootQ] += rank[rootP];
            longest = Math.max(longest, rank[rootQ]);
        } else {
            parent[rootQ] = rootP;
            rank[rootP] += rank[rootQ];
            longest = Math.max(longest, rank[rootP]);
        }
    }

    public int getLongest() {
        return longest;
    }
}

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

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

        return uf.getLongest();
    }
}
