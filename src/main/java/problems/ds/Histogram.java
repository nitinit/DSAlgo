package problems.ds;// You have been given an integer array  and the array elements represent the heights of a histogram bar
// you need to calculate the area of the largest rectangle that can be formed using consecutive bars
// You can assume all bars to be of same width (width = 1 unit)
// input array => {1,2,3,4,5,6,2,8,1,7,3}

public class Histogram {

    static int calcLargestRectArea(int[] heights) {
        int maxHArea = -1;

        for (int i = 0; i < heights.length; i++) {
            int tmpArea = heights[i];
            int rightSideArea = 0;
            int leftSideArea = 0;

               // rightSideArea = heights[i];
                for (int j = i + 1; j < heights.length; j++) {
                    if (heights[j] >= heights[i]) {
                        rightSideArea += heights[i];
                    } else {
                        break;
                    }
                }

                //leftSideArea = heights[i];
                for (int k = i - 1; k >= 0; k--) {
                    if (heights[k] >= heights[i]) {
                        leftSideArea += heights[i];
                    } else {
                        break;
                    }
                }

            if (tmpArea + rightSideArea + leftSideArea > maxHArea) {
                maxHArea = tmpArea + rightSideArea + leftSideArea;
            }
        }
        return maxHArea;

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 2, 8, 1, 7, 3};

        System.out.println("Area Of Largest Are:" + calcLargestRectArea(arr));

    }


}