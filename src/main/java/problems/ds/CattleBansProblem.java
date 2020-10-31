package problems.ds;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CattleBansProblem {

    boolean isValid(int desiredCount, int cowCount, int[] positions) {
        int lastPosition = positions[0];
        int cowPlaced = 1;
        for (int i = 1; i < positions.length; i++) {
            if (positions[i] - lastPosition >= desiredCount) {
                lastPosition = positions[i];
                cowPlaced += 1;
                if (cowPlaced == cowCount) {
                    return true;
                }
            }
        }
        return false;
    }

    public int solve(int[] cowPositions, int cowCount) {
        int low = 0;
        int high = cowPositions[cowPositions.length - 1] - cowPositions[0];
        int result = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isValid(mid, cowCount, cowPositions)) {
                low = mid + 1;
                result = Math.max(mid, result);
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    @Test
    public void test1() {
        int[] cowPositions = new int[]{1, 2, 4, 8, 9};

        int bestPosition = solve(cowPositions, 3);
        System.out.println("Best-Position:"+bestPosition);

       // boolean isValid = isValid(3, 3, cowPositions);
       // System.out.println(isValid);
        //assertEquals(1, getExcelColumnPosition("A"));
    }
}
