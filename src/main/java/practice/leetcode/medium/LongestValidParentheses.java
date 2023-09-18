package practice.leetcode.medium;

import java.util.Stack;

/*
Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses
substring.
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
//        String s = "(()"; // 2
//        String s = ")()())"; // 4
//        String s = "()"; // 2
        String s = "()(()"; // 2
        System.out.println(longestValidParentheses(s));
    }

    static int longestValidParentheses(String s) {
        if (s.isEmpty() || s.length() == 1) return 0;
        int maxLength = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // If only one parenthesis, return 0
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    // Max of current length (current index - last index of '(') and previous length
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        return maxLength;
    }
}
