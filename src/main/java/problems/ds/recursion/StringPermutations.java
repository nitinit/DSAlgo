package problems.ds.recursion;

import org.junit.Test;

public class StringPermutations {

    public void printSubsequences(String ques, String ans) {
        if (ques.length() == 0) {
            System.out.println(ans);
            return;
        }
        char ch = ques.charAt(0);
        String roq = ques.substring(1);

        printSubsequences(roq, ans + ch);
        printSubsequences(roq, ans + "");
    }

    public void printPermuations(String ques, String ans) {
        if (ques.length() == 0) {
            System.out.println(ans);
            return;
        }
        for(int i = 0; i < ques.length(); i++) {
            char ch = ques.charAt(i);
            String roq = ques.substring(0, i) + ques.substring(i+1, ques.length());
            printPermuations(roq, ans + ch);
        }
    }

    @Test
    public void test1() {
        printSubsequences("abc", "");
    }

    @Test
    public void test2() {
        printPermuations("abc", "");
    }
}
