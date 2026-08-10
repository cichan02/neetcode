class Solution {
    public int singleNumber(int[] nums) {
        return IntStream.of(nums).reduce(0, (a, b) -> a ^ b);
    }
}
