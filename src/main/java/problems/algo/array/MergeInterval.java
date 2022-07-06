package problems.algo.array;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeInterval {

    //Wrong Solution
    public int[][] merge1(int[][] intervals) {
        int[][] result = new int[5][2];
        int resultIdx = 0;
        int i=0;
        for (; i < intervals.length-1; i++) {
            int endIdx = i;
            while(intervals[endIdx][1] > intervals[endIdx+1][0] && endIdx < intervals.length -2) {
                endIdx++;
            }
            result[resultIdx++] = new int[] {intervals[i][0], intervals[endIdx][1]};
            i = endIdx;
        }
        if( i <= intervals.length-1) {
            result[resultIdx] = intervals[i];
        }
        return result;
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String args[]) {
        MergeInterval mergeInterval = new MergeInterval();
        //int[][] input = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        //int[][] input = new int[][]{{1,3},{2,6},{8,10},{9,18}};
        //int[][] input = new int[][]{{1,3},{2,6},{5,10},{9,18}};
        int[][] input = new int[][]{{1,9},{2,5},{19,20},{10,11},{12,20},{0,3},{0,1},{0,2}};


        int[][] result = mergeInterval.merge(input);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + ",");
            }
        }
    }
}
