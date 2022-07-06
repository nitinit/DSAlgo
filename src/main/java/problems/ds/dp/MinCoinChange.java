package problems.ds.dp;

public class MinCoinChange {

    public int coinChange(int coins[], int amount) {
        return recursionHelper(coins, amount);
    }

    public int recursionHelper(int[] coins, int remain) {
        if(remain < 0) return -1;
        if(remain == 0) return 0;

        int minCount = Integer.MAX_VALUE;

        for (int coin : coins) {
            int count = recursionHelper(coins, remain - coin);
            if(count == -1) continue;
            minCount = Math.min(minCount, count+1);
        }
        return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }


    public static void main(String args[]) {
        MinCoinChange minCoinChange = new MinCoinChange();
        int[] coins = new int[] {2, 5};
        minCoinChange.coinChange(coins, 10);
    }
}
