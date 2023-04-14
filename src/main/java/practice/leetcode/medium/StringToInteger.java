package practice.leetcode.medium;

public class StringToInteger {
    public static void main(String[] args) {
        String s1 = "42";
        String s2 = "   -42";
        String s3 = "4193 with words";
        String s4 = "-91283472332"; // -2147483648
        String s5 = "+1"; // 1
        String s6 = "  "; // 0
        String s7 = "9223372036854775808"; // 2147483647
        String s8 = "18446744073709551617"; // 2147483647
        System.out.println(myAtoi(s8));
    }

    static int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) return 0;
        int i = 0;
        long result = 0;
        boolean isNegative = s.charAt(i) == '-';
        if (isNegative || s.charAt(i) == '+') i++;

        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            result = result * 10 + s.charAt(i++) - '0';
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return isNegative ? (int) -result : (int) result;
    }
}
