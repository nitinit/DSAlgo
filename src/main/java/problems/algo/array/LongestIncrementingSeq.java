package problems.algo.array;

import java.util.ArrayList;

public class LongestIncrementingSeq {

    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num > sub.get(sub.size() - 1)) {
                sub.add(num);
            } else {
                // Find the first element in sub that is greater than or equal to num
                int j = 0;
                while (num > sub.get(j)) {
                    j += 1;
                }
                sub.set(j, num);
            }
        }
        for (int a : sub) {
            System.out.print(a + ",");
        }
        return sub.size();
    }

    // 10
    //

    public static void main(String args[]) {
        LongestIncrementingSeq lis = new LongestIncrementingSeq();
        int[] input = new int[] {10,9,2,5,3,7,101,18};
        System.out.println(lis.lengthOfLIS(input));
    }
}