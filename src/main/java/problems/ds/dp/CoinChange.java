package problems.ds.dp;

import java.util.*;

public class CoinChange {

    static void getPossibleCombination(int[] coins, int beginWith, int value, List<List<Integer>> result, List<Integer> temp) {
        if (value == 0) {
            result.add(new ArrayList<>(temp));
        }

        for (int i = beginWith; i < coins.length && coins[i] <= value; i++) {
            temp.add(coins[i]);
            getPossibleCombination(coins, i, value - coins[i], result, temp);
            int index = temp.size() - 1;
            temp.remove(index);
        }
    }

    static void coinChangeCombinations(int i, int[] coins, int amtsf, int targetAmt, List<List<Integer>> result, List<Integer> partResult) {
        if (i == coins.length) {
            if (amtsf == targetAmt) {
                result.add(partResult);
            }
            return;
        }
        if (amtsf == targetAmt) {
            result.add(partResult);
            return;
        }

        for (int j = targetAmt / coins[i]; j >= 1; j--) {
            List<Integer> tmpResult = new ArrayList<>();
            for (int k = 0; k < j; k++) {
                tmpResult.add(coins[i]);
            }
            tmpResult.addAll(partResult);
            coinChangeCombinations(i + 1, coins, amtsf + coins[i] * j, targetAmt, result, tmpResult);
        }
        coinChangeCombinations(i + 1, coins, amtsf, targetAmt, result, partResult);
    }

    // No Duplicate coins involved
    public void coinChange(int i, int[] coins, int amtsf, int targetAmt, String result) {
        if (i == coins.length) {
            if (amtsf == targetAmt) {
                System.out.println(result + ".");
            }
        }

        coinChange(i + 1, coins, amtsf + coins[i], targetAmt, result + coins[i] + "-");
        coinChange(i + 1, coins, amtsf, targetAmt, result);
    }

    public int count(int S[], int m, int targetAmt) {
        if (targetAmt == 0)
            return 1;

        if (targetAmt < 0)
            return 0;

        if (m <= 0 && targetAmt >= 1)
            return 0;

        return count(S, m - 1, targetAmt) +
                count(S, m, targetAmt - S[m - 1]);
    }

    // Driver code
    public static void main(String[] args) {
        Integer[] arr = {2, 3, 5};
        Vector<Integer> A = new Vector<>(Arrays.asList(arr));

        int K = 8;

        int[] elements = {2, 3, 5};
        int result = 8;
        List<List<Integer>> result1 = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();

        getPossibleCombination(elements, 0, 8, result1, tmp);
        System.out.println(result1);

        // 2 2 2 2
        // 2 3 3
        // 3 5
        result1 = new ArrayList<>();
        tmp = new ArrayList<>();
        coinChangeCombinations(0, elements, 0, 8, result1, tmp);
    }
}