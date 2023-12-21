package practice.leetcode.medium;

/*
The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
countAndSay(1) = "1"
countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
To determine how you "say" a digit string, split it into the minimal number of substrings such that each substring contains exactly one unique digit. Then for each substring, say the number of digits, then say the digit. Finally, concatenate every said digit.

Given a positive integer n, return the nth term of the count-and-say sequence.
Example 1:
Input: n = 1
Output: "1"
Explanation: This is the base case.

Example 2:
Input: n = 4
Output: "1211"
Explanation:
countAndSay(1) = "1"
countAndSay(2) = say "1" = one 1 = "11"
countAndSay(3) = say "11" = two 1's = "21"
countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
 */
public class CountAndSay {
    public static void main(String[] args) {
        int n = 4; // 1211
        System.out.println(countAndSay(n));
    }

    static String countAndSay(int n) {
        String[] result = new String[n];
        result[0] = "1"; // base case
        for (int i = 1; i < n; i++) {
            result[i] = countAndSayConvert(result[i - 1].toCharArray());
        }
        return result[n - 1];
    }

    private static String countAndSayConvert(char[] charArray) {
        int count = 1;
        char c = charArray[0];
        StringBuilder stringBuilder = new StringBuilder(); // <count><charArray[i]>
        for (int i = 1; i < charArray.length; i++) {
            if (c == charArray[i]) {
                // If the character is already existed -> increase that character by 1
                count++;
            } else {
                // If the character is not existed -> stop counting and add result to the string
                stringBuilder.append(count);
                stringBuilder.append(c);
                c = charArray[i];
                count = 1;
            }
        }
        stringBuilder.append(count);
        stringBuilder.append(c);
        return stringBuilder.toString();
    }
}
