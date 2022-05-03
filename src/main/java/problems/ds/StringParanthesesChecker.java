package problems.ds;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringParanthesesChecker {
	Map<Character, Character> validCharMap = new HashMap<>();

	public boolean isValidParantheses(String input) {

		Stack<Character> stack = new Stack<>();

		for (char ch : input.toCharArray()) {
			if (validCharMap.containsKey(ch)) {
				stack.push(ch);
			} else if (!stack.empty() && validCharMap.get(stack.peek()) == ch) {
				stack.pop();
			} else {
				return false;
			}
		}
		return stack.empty();
	}

	void initValidParantheses() {
		validCharMap.put('{', '}');
		validCharMap.put('[', ']');
		validCharMap.put('(', ')');
	}

	private List<Integer> toVersionList(final String versions) {
		return Stream.of(versions.split(",")).map(String::trim).map(Integer::parseInt).collect(Collectors.toList());
	}

	public static void main(String args[]) {

		StringParanthesesChecker paranthesesChecker = new StringParanthesesChecker();
		paranthesesChecker.initValidParantheses();

//		System.out.println("Example-1" + paranthesesChecker.isValidParantheses("()"));
//		System.out.println("Example-2" + paranthesesChecker.isValidParantheses("()[]{}"));
//
//		System.out.println("Example-3" + paranthesesChecker.isValidParantheses("(]"));
//
		System.out.println("Example-4" + paranthesesChecker.isValidParantheses("([)]"));
//
		System.out.println("Example-5" + paranthesesChecker.isValidParantheses("{[]}"));

		//System.out.println(paranthesesChecker.toVersionList(" 12, 4 5"));

	}
}
