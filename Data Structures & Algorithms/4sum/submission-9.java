class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        kSum(4, res, new ArrayList<>(), 0, nums, target);

        return res;
    }

    private void kSum(int k, List<List<Integer>> res, List<Integer> combination, int i, int[] nums, long target) {
        if (k == 2) {
            twoSum(res, combination, i, nums, target);
            return;
        }

        for (int j = i; j < nums.length - k + 1; j++) {
            if (j > i && nums[j] == nums[j - 1]) {
                continue;
            }
            combination.add(nums[j]);
            kSum(k - 1, res, combination, j + 1, nums, target - nums[j]);
            combination.removeLast();
        }
    }

    private void twoSum(List<List<Integer>> res, List<Integer> combination, int i, int[] nums, long target) {
        int l = i, r = nums.length - 1;
        while (l < r) {
            switch (Long.signum(nums[l] + nums[r] - target)) {
                case 1 -> r--;
                case -1 -> l++;
                case 0 -> {
                    List<Integer> tmp = Stream.concat(
                            Stream.of(nums[l++], nums[r--]),
                            combination.stream()
                    ).toList();
                    res.add(tmp);
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
                }
            }
        }
    }
}