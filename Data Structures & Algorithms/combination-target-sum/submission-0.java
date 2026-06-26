class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        return step(new HashSet<>(), new ArrayList<>(), 0, nums, target).stream().toList();
    }

    public Set<List<Integer>> step(Set<List<Integer>> ans, List<Integer> curr, int sum , int[] nums, int target) {
        for (int peek : nums) {
            sum += peek;
            curr.add(peek);
            if (sum == target) {
                List<Integer> list = new ArrayList<>(curr)
                        .stream()
                        .sorted()
                        .toList();
                ans.add(list);
            } else if (sum < target) {
                step(ans, curr, sum, nums, target);
            }
            int last = curr.remove(curr.size() - 1);
            sum -= last;
        }
        return ans;
    }
}
