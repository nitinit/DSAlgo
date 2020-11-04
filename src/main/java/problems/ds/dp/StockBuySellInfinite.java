package problems.ds.dp;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StockBuySellInfinite {

    public int maxProfit(int prices[]) {
        int totalProfit = 0;
        int lowestSoFar = Integer.MAX_VALUE;
        int tempMax = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < lowestSoFar) {
                lowestSoFar = prices[i];
                totalProfit += tempMax;
                tempMax = 0;
            } else if ((prices[i] - lowestSoFar) > tempMax) {
                tempMax = prices[i] - lowestSoFar;
            }
        }
        return totalProfit + tempMax;
    }

    public int maxProfitPoint(int prices[]) {
        int totalProfit = 0;
        int buyPoint = 0;
        int sellPoint = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= prices[i - 1]) {
                sellPoint = i;
            } else {
                totalProfit += prices[sellPoint] - prices[buyPoint];
                buyPoint = sellPoint = i;
            }
        }
        return totalProfit;
    }

    @Test
    public void test1() {

        int[] prices = new int[]{11, 6, 7, 19, 4, 1, 6, 18, 4};
        assertEquals(30, maxProfit(prices));
        assertEquals(30, maxProfitPoint(prices));
    }
}
