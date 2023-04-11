package practice.leetcode.easy;

import java.util.HashMap;

/**
 * Đổi chữ số La Mã sang số nguyên
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 */
public class RomanToInteger {
    public static void main(String[] args) {
        String case1 = "III";
        String case2 = "LVIII";
        String case3 = "MCMXCIV";

        System.out.println(romanToInteger(case2));
    }

    static int romanToInteger(String s) {
        int sum = 0;
        HashMap<Character, Integer> roman = new HashMap<>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        for (int i = 0; i < s.length(); i++) {
            // if the smaller number before the larger number: subtract (IV(4) = V(5) - I(1))
            if (i + 1 < s.length() && roman.get(s.charAt(i)) < roman.get(s.charAt(i + 1))) {
                sum -= roman.get(s.charAt(i));
            } else {
                // if the larger number before the smaller number: sum up
                sum += roman.get(s.charAt(i));
            }
        }
        return sum;
    }
}
