class Solution {
    final List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(new ArrayList<>(), nums, 0, target);
        return res;
    }

    public void backtrack(List<Integer> curr, int[] nums, int i, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if (target < 0 || i >= nums.length) {
            return;
        }

        curr.add(nums[i]);
        backtrack(curr, nums, i, target - nums[i]);
        curr.remove(curr.size() - 1);
        backtrack(curr, nums, i + 1, target);
    }
}
