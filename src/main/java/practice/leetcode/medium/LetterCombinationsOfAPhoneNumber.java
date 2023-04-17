package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    private static final String[] KEYS = new String[]{
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public static void main(String[] args) {
//        String digits = "23";
//        String digits = "";
        String digits = "2";
        for (String letter : letterCombinations(digits)) {
            System.out.println(letter);
        }
    }

    static List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits == null || digits.length() == 0) return combinations;
        generateCombinations(digits, 0, "", combinations);
        return combinations;
    }

    private static void generateCombinations(String digits, int index, String current, List<String> combinations) {
        // When we reach the end of the input string, we add the current combination to the output list.
        if (index == digits.length()) {
            combinations.add(current);
            return;
        }
        // Get the int value of the digit character
        int digit = digits.charAt(index) - '0';
        // Get the corresponding combination string of the digit character
        String letters = KEYS[digit];
        // Iterate through the letters corresponding to the current digit
        for (int i = 0; i < letters.length(); i++) {
            // Call the function with the next index, add a new letter to the current string
            generateCombinations(digits, index + 1, current + letters.charAt(i), combinations);
        }
    }
}
