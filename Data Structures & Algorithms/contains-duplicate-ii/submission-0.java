class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int l = 0;
        boolean res = false;
        for (int r = 0; r < nums.length; r++) {
            int rf = freq.getOrDefault(nums[r], 0) + 1;
            freq.put(nums[r], rf);
            while (r - l > k) {
                int lf = freq.get(nums[l]) - 1;
                freq.put(nums[l], lf);
                l++;
            }
            if (freq.values().stream().filter(v -> v > 1).findAny().isPresent()) {
                return true;
            }
        }
        return false;
    }
}