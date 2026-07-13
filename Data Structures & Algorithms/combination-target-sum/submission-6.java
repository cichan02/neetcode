class Solution {
    private List<List<Integer>> res;
    
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(new ArrayList<>(), nums, 0, target);
        return res;
    }

    public void backtrack(List<Integer> list, int[] nums, int cur, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
        }

        if (target < 0 && cur >= nums.length) {
            return;
        }

        for (int i = cur; i < nums.length; i++) {
            int num = nums[i];
            if (target - num >= 0) {
                list.add(num);
                backtrack(list, nums, i, target - num);
                list.removeLast();
            }
        }
    }
}
