package problems.ds.greedy;

import java.util.Arrays;

//https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/
public class MinTapsToWaterGarden {

    public static int minTaps1(int n, int[] ranges) {
        // 1. create ranges and sort by start position in non descending order
        int[][] rarr = new int[ranges.length][2];
        for(int i = 0; i < ranges.length; i++) {
            rarr[i][0] = (i - ranges[i]) >=0 ? i - ranges[i]:0;
            rarr[i][1] = (i + ranges[i]) <= n?i + ranges[i]:n;
        }
        Arrays.sort(rarr, (a, b) -> (a[0]==b[0]?a[1]-b[1]:a[0]-b[0]));

        /* for(int[] row:rarr)
            System.out.println(row[0]+" "+row[1]);*/

        int endAt = 0;
        int tapCount=0;
        while(endAt!=n) {
            // find intersection top right
            // intersection has start <= endAt
            int maxEndAt=-1;
            for(int i = 0; i <rarr.length && rarr[i][0]<=endAt;i++) {
                maxEndAt = Math.max(maxEndAt, rarr[i][1]);
            }
            if(maxEndAt==-1 || maxEndAt==endAt) return -1;
            tapCount++;
            endAt=maxEndAt;
        }

        return tapCount;
    }

    public static int minTaps(int n, int[] ranges) {
        int min =0, max =0, open = 0;

        while(max < n) {
            for(int i = 0; i < ranges.length; i++) {
                if(i - ranges[i] <= min && i + ranges[i] > max) {
                    max = i + ranges[i];
                }
            }
            if(min == max) return -1;
            System.out.println("max:"+max);
            open++;
            min = max;
        }
        return open;
    }

    public static void main(String[] args) {
        //System.out.println(minTaps(5, new int[] {2, 1, 1, 2, 1}));
        //System.out.println(minTaps(5, new int[] {3,4,1,1,0,0}));
        System.out.println(minTaps(5, new int[] {3,3,1,1,1,0}));
        System.out.println(minTaps(5, new int[] {3,3,1,1,0,0}));

    }
}