package problems.ds;


// You have been given an integer array  and the array elements represent the heights of a histogram bar
// you need to calculate the area of the largest rectangle that can be formed using consecutive bars
// You can assume all bars to be of same width (width = 1 unit)
// input array => {1,2,3,4,5,6,2,8,1,7,3}

import java.util.Stack;

public class Histogram {

    static int calcLargestRectArea1(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int i =0;
        for(i = 0; i < heights.length;) {
            if(stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i++);
            } else {
                int tmp = stack.pop();
                int tmpArea = 0;
                if(!stack.isEmpty()) {
                    System.out.print("i:"+i +", Stack-Top:"+stack.peek() +", tmp:"+tmp);
                    tmpArea = (i - stack.peek() -1) * heights[tmp];
                    System.out.println(",Area:"+tmpArea);
                } else {
                    tmpArea = heights[tmp] * i;
                }
                if (tmpArea > maxArea) {
                    maxArea = tmpArea;
                }
            }
        }
        while (!stack.isEmpty()) {
            int tmp = stack.pop();
            int tmpArea = 0;
            if(!stack.isEmpty()) {
                tmpArea = (i - stack.peek() -1) * heights[tmp];
            } else {
                tmpArea = heights[tmp] * heights.length;
            }
            if (tmpArea > maxArea) {
                maxArea = tmpArea;
            }
        }
        return maxArea;
    }

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
        //int[] arr = {1, 2, 3, 4, 5, 6, 2};

        System.out.println("Area Of Largest Are:" + calcLargestRectArea1(arr));
    }
}