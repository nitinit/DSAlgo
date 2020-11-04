package problems.ds.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StockBuySellWithCoolDownPeriod {

    public int maxProfit(int prices[], int coolDownPeriod) {
        int oldBuyShareState = prices[0];
        int oldSellShareState = 0;
        int oldCoolDownShareState = 0;

        for(int i = 1; i < prices.length; i++) {
            int newBuyShareState = 0;
            int newSellShareState = 0;
            int newCoolDownShareState = 0;
            if(prices[i] - oldCoolDownShareState < oldBuyShareState) {
                newBuyShareState = prices[i] - oldCoolDownShareState;
            } else {
                newBuyShareState = oldBuyShareState;
            }
            if(prices[i]  - oldBuyShareState > oldSellShareState) {
                newSellShareState = prices[i]  - oldBuyShareState;
            } else {
                newSellShareState = oldSellShareState;
            }

            if(oldCoolDownShareState < oldSellShareState) {
                newCoolDownShareState = oldSellShareState;
            } else {
                newCoolDownShareState = oldCoolDownShareState;
            }
            oldBuyShareState = newBuyShareState;
            oldSellShareState = newSellShareState;
            oldCoolDownShareState = newCoolDownShareState;
        }
        return oldSellShareState;
    }

    @Test
    public void test1() {

        int[] prices = new int[]{10, 15, 17, 20, 16, 18, 22, 20, 22, 20, 23, 25};
        assertEquals(19, maxProfit(prices, 1));

        prices = new int[]{10, 20, 30};
        assertEquals(20, maxProfit(prices, 2));
    }
}
