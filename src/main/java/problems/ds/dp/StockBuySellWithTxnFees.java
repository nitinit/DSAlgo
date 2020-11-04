package problems.ds.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StockBuySellWithTxnFees {

    public int maxProfit(int prices[], int txnFee) {
        int oldBuyShareState = prices[0];
        int oldSellShareState = 0;

        for(int i = 1; i < prices.length; i++) {
            int newBuyShareState = 0;
            int newSellShareState = 0;
            if(prices[i] - oldSellShareState < oldBuyShareState) {
                newBuyShareState = prices[i] - oldSellShareState;
            } else {
                newBuyShareState = oldBuyShareState;
            }
            if(prices[i] - txnFee - oldBuyShareState > oldSellShareState) {
                newSellShareState = prices[i] - txnFee - oldBuyShareState;
            } else {
                newSellShareState = oldSellShareState;
            }
            oldBuyShareState = newBuyShareState;
            oldSellShareState = newSellShareState;
        }
        return oldSellShareState;
    }

    @Test
    public void test1() {

        int[] prices = new int[]{10, 15, 17, 20, 16, 18, 22, 20, 22, 20, 23, 25};
        assertEquals(13, maxProfit(prices, 3));

        prices = new int[]{10, 20, 30};
        assertEquals(18, maxProfit(prices, 2));
    }
}
