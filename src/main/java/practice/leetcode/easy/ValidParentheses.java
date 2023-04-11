package practice.leetcode.easy;

import java.util.Stack;

/**
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 */
public class ValidParentheses {
    public static void main(String[] args) {
        String s1 = "()"; // true
        String s2 = "()[]{}"; // true
        String s3 = "(]"; // false
        System.out.println(isValidParentheses(s2));
    }

    static boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            // Put open parenthesis into stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // If the closing parenthesis is not matched with an open parenthesis -> false
                if (stack.isEmpty() ||
                        (stack.peek() == '(' && c != ')') ||
                        (stack.peek() == '{' && c != '}') ||
                        (stack.peek() == '[' && c != ']')) {
                    return false;
                }
                // If opening parenthesis is matched with an opening parenthesis -> pop the opening parenthesis
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
