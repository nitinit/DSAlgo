package problems.algo.array;

public class ElementsProdExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {
            if (i ==0)
                ans[i] = 1;
            else
                ans[i] = ans[i-1] * nums[i-1];
        }

        int rProd = 1;
        for (int j = length-1; j >=0; j--) {
            if(j == length -1)
                rProd = 1;
            else
                rProd = rProd * nums[j+1];
            ans[j] = ans[j] * rProd;
        }
        return ans;
    }
}
