package problems.ds.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinations {

        private static Map<Character, String> letters = Map.of(
            '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");

        static List<String> answer = new ArrayList<>();

        public static List<String> letterCombinations(String digits) {
            int index = 0;
            StringBuilder path = new StringBuilder();
            solve(digits, path, index);
            System.out.println("output:"+ answer);
            return answer;
        }

        public static void solve(String digits, StringBuilder path, int index) {
            if(index >= digits.length()) {
                answer.add(path.toString());
                return;
            }
            String comb = letters.get(digits.charAt(index));

            for (char ch : comb.toCharArray()) {
                path.append(ch);
                solve(digits, path, index +1);
                path.deleteCharAt(path.length() -1);
            }
        }

        public static void main(String args[]) {
            letterCombinations("23");

    }
}
