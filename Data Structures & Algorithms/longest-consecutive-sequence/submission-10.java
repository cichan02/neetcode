class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        nums = IntStream.of(nums).distinct().sorted().toArray();
        int res = 1, temp = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i-1] == 1) {
                temp++;
            } else {
                res = Math.max(res, temp);
                temp = 1;
            }
        }
        return Math.max(res, temp);
    }
}
