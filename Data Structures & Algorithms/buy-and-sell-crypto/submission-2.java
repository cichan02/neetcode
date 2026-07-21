class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, maxProfit = 0;
        int[] prefix =  new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            prefix[i] = min;
        }

        for (int i = prices.length - 1; i > 0; i--) {
            max = Math.max(max, prices[i]);
            maxProfit = Math.max(maxProfit, max - prefix[i-1]);
        }
        return maxProfit;
    }
}
