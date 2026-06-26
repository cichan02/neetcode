class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        dfs(ans, new ArrayList<>(),  nums, 0, 0, target);
        return ans;
    }

    public void dfs(List<List<Integer>> ans, List<Integer> curr, int[] nums, int i, int sum, int target) {
        if (sum == target) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int j = i; j < nums.length; j++) {
            if (nums[j] + sum > target) {
                return;
            }

            curr.add(nums[j]);
            dfs(ans, curr, nums, j, sum + nums[j], target);
            curr.remove(curr.size() - 1);
        }
    }
}
