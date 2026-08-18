class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        backtrack(res, new ArrayList<>(), nums, 0, target);

        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> cur, int[] nums, int i, int target) {
        if (target == 0) {
            res.add(List.copyOf(cur));
            return;
        }

        if (target < 0 || i > nums.length) {
            return;
        }

        for (int j = i; j < nums.length; j++) {
            if (nums[j] > target) {
                return;
            }

            cur.add(nums[j]);
            backtrack(res, cur, nums, j, target - nums[j]);
            cur.removeLast();
        }
    }
}
