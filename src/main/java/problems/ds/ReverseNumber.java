package problems.ds;

public class ReverseNumber {

    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;

            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            result = result * 10 + pop;
        }
        return result;
    }

    public static void main(String args[]) {
        System.out.println(reverse(-1));

        System.out.println(reverse(2147483647));

        System.out.println(reverse(1117483312));
    }

}