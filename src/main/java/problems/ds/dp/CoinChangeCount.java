package problems.ds.dp;

import java.util.ArrayList;
import java.util.List;

public class CoinChangeCount {

    int result = 0;
    public int change(int amount, int[] coins) {
        coinChangeRequired(amount, coins, 0, amount);
        return result;
    }

    public void coinChangeRequired(int amount, int[] coins, int idx, int targetAmount) {
        if(targetAmount ==0) {
            result++;
            return;
        }

        for (int i = idx; i < coins.length && coins[i] <= targetAmount; i++) {
            coinChangeRequired(amount, coins, i, targetAmount - coins[i]);
        }
    }

    public List<List<Integer>> combinations = new ArrayList<List<Integer>>();

    public int coinChangeCount(int amount, int[] coins) {
        List<Integer> list = new ArrayList<Integer>();
        count(amount, coins, 0, list);
        return result;
    }

    public void count(int amount, int[] coins, int idx, List<Integer> list) {
        if (amount == 0) {
            result++;
            combinations.add(new ArrayList<>(list));
            return;
        }

        for (int i = idx; i < coins.length && coins[i] <= amount; i++) {
            list.add(coins[i]);
            count(amount - coins[i], coins, i, list);
            int tmp = list.size() - 1;
            list.remove(tmp);
        }
    }

    public static void main(String args[]) {
        CoinChangeCount coinChangeCount = new CoinChangeCount();
        int[] arr = {1, 2, 5};
        System.out.print(coinChangeCount.coinChangeCount(5, arr));
        System.out.println(coinChangeCount.combinations);
    }
}
