package problems.design.tricky;

/*
“Arranging Coins” asks you to build a staircase with these coins.
 The staircase consists of k rows, where ith row consists of exactly i coins.
 */
public class ArrangeCoinsStaircase {

    public int arrangeCoins(int n) {
        int ans = 1;
         while (n > 0) {
             ans++;
             n = n - ans;
         }
        return ans -1;
    }
}