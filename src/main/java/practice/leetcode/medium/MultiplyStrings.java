package practice.leetcode.medium;

/*
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

Example 1:
Input: num1 = "2", num2 = "3"
Output: "6"

Example 2:
Input: num1 = "123", num2 = "456"
Output: "56088"

Constraints:
1 <= num1.length, num2.length <= 200
num1 and num2 consist of digits only.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 */
public class MultiplyStrings {
    public static void main(String[] args) {
        String num1 = "0";
        String num2 = "0";
        System.out.println(multiply(num1, num2));
    }

    static String multiply(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();

        int[] position = new int[n + m]; // total digits = number of digits num1 + number of digits num2
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int multiply = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = multiply + position[p2]; // Sum the multiplier and the decimal of the latest sum part
                position[p1] += sum / 10; // Accumulate the int part of the sum to p1
                position[p2] = sum % 10; // Put the decimal of the sum part to p2
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : position) {
            if (i != 0 || !stringBuilder.isEmpty())
                stringBuilder.append(i);
        }
        return stringBuilder.toString().isEmpty() ? "0" : stringBuilder.toString();
    }
}
