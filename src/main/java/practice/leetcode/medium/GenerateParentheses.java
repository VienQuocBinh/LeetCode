package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        int n = 2;
        for (String s : generateParenthesis(n)) {
            System.out.println(s);
        }
    }

    static List<String> generateParenthesis(int n) {
        List<String> parentheses = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        generate(parentheses, current, n, n);
        return parentheses;
    }

    /*
    List<String> result: store the result list
    StringBuilder current: current parentheses string
    int openChar: the number of open characters required
    int closeChar: the number of close characters required
     */
    static void generate(List<String> result, StringBuilder current, int openChar, int closeChar) {
        // If the number of open and close characters == n (enough open and close characters required) then add current string to result
        if (openChar == 0 && closeChar == 0) result.add(current.toString());

        // If the number of open characters > 0 (not enough required)
        if (openChar > 0) {
            // append '(' character and decrement the number of open characters required
            generate(result, current.append('('), openChar - 1, closeChar);
            // Remove the last char of current string after adding current to result list
            current.deleteCharAt(current.length() - 1);
        }

        // If the number of close characters > 0 (not enough required)
        // If current string length != 0 (contains at least one open character)
        // If the number of required open and close characters are different (need at least one close character)
        if (current.length() != 0 && closeChar > 0 && openChar != closeChar) {
            // append ')' character and decrement the number of close characters required
            generate(result, current.append(')'), openChar, closeChar - 1);
            // Remove the last char of current string after adding current to result list
            current.deleteCharAt(current.length() - 1);
        }
    }
}
