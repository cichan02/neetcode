class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int[] prefix =  new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            prefix[i] = min;
        }

        int max = Integer.MIN_VALUE;
        int[] postfix = new int[prices.length];
        for (int i = prices.length - 1; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            postfix[i] = max;
        }

        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, postfix[i] - prefix[i - 1]);
        }
        return maxProfit;
    }
}
