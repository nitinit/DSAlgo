package problems.ds.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StockBuySellOnce {

    public int maxProfit(int prices[]) {
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > maxProfit) {
                    maxProfit = prices[j] - prices[i];
                }
            }
        }
        return maxProfit;
    }

    public int maxProfitOptimized(int prices[]) {
        int maxProfit = Integer.MIN_VALUE;
        int lowestSoFar = Integer.MAX_VALUE;
        int tempMax = 0;

        for (int i = 0; i < prices.length; i++) {
            if(prices[i] < lowestSoFar) {
                lowestSoFar = prices[i];
            }
            tempMax = prices[i] - lowestSoFar;
            if(tempMax > maxProfit) {
                maxProfit = tempMax;
            }
        }
        return maxProfit;
    }

    @Test
    public void test1() {

        int[] prices = new int[]{11, 6, 7, 19, 4, 1, 6, 18, 4};
        assertEquals(17, maxProfit(prices));
        assertEquals(17, maxProfitOptimized(prices));
    }


}
