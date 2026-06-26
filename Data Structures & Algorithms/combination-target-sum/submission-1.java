class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        dfs(ans, new ArrayList<>(), nums, 0, 0, target);
        return ans;
    }

    public void dfs(List<List<Integer>> ans, List<Integer> curr, int[] nums, int i, int sum, int target) {
        if (sum == target) {
            ans.add(new ArrayList<>(curr));
            return;
        } else if (sum > target || i == nums.length) {
            return;
        }

        curr.add(nums[i]);
        dfs(ans, curr, nums, i, sum + nums[i], target);
        curr.remove(curr.size() - 1);
        dfs(ans, curr, nums, i + 1, sum, target);
    }
}
