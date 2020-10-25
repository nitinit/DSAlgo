package problems.ds;

public class NumberPalindrom {
    public static boolean isPalindrom(int x) {

        if (x < 0 || x % 10 == 0) {
            return false;
        }

        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + (x % 10);
            x = x / 10;
        }
        return (x == rev) || x == rev / 10;
    }

    public static void main(String args[]) {
        System.out.println(isPalindrom(0));
        System.out.println(isPalindrom(1221));
        System.out.println(isPalindrom(12321));

    }

}
