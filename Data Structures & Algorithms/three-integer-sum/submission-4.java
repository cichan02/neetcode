class Solution {
    private Set<List<Integer>> twoSum(int[] nums, int t) {
        int i = 0, j = nums.length - 1;
        Set<List<Integer>> result = new HashSet<>();
        while (i < j) {
            if (i == t || nums[i] + nums[j] + nums[t] < 0) {
                i++;
                continue;
            }

            if (j == t || nums[i] + nums[j] + nums[t] > 0) {
                j--;
                continue;
            }

            result.add(Stream.of(nums[i], nums[j], nums[t]).sorted().toList());
            i++;
            j--;
        }

        return result;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> resultSet = new HashSet<>();
        for (int t = 0; t < nums.length; t++) {
            resultSet.addAll(twoSum(nums, t));
        }
        return resultSet.stream().toList();
    }
}
