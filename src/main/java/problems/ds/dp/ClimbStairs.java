package problems.ds.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClimbStairs {

    public int climbStairsWith2Steps(int stairsCnt) {
        if (stairsCnt == 1) {
            return 1;
        }
        if (stairsCnt == 2) {
            return 2;
        }
        return climbStairsWith2Steps(stairsCnt - 1) + climbStairsWith2Steps(stairsCnt - 2);
    }

    public int climbStairsMSteps(int stairsCnt, int m) {
        if (stairsCnt <= 1) {
            return stairsCnt;
        }
        int result = 0;
        for (int i = 1; i <= stairsCnt && i <= m; i++) {
            result += climbStairsMSteps(stairsCnt - i, m);
        }
        return result;
    }

    public int climbStairsMStepsDP(int stairsCnt, int m) {
        int[] dp = new int[stairsCnt];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < stairsCnt; i++) {
            dp[i] = 0;
            for (int j = 1; j <= m && j <= i; j++) {
                dp[i] += dp[i - j];
            }
        }
        return dp[stairsCnt - 1];
    }

    @Test
    public void test1() {
        assertEquals(5, climbStairsWith2Steps(4));
        assertEquals(5, climbStairsMSteps(5, 2));
        assertEquals(5, climbStairsMStepsDP(5, 2));

    }
}
