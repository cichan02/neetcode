class Solution {
    public boolean hasDuplicate(int[] nums) {
        return IntStream.of(nums).distinct().count() < nums.length;
    }
}