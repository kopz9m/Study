package LeetCode;

public class _122_BestTimeToBuyAndSellStockii {
    public int maxProfit(int[] prices) {

        boolean isHolding = false;
        int buyPrice, sellPrice, profit = 0;
        int len = prices.length;

        for (int i = 0; i < len - 1; i++) {

            if (prices[i] < prices[i + 1]) {

                profit += prices[i + 1] - prices[i];

            }
        }
        return profit;

    }
}
