package practice.leetcode.medium;

public class ReverseInteger {
    public static void main(String[] args) {
        int x = 123; // 321
        int x1 = -123; // -321
        int x2 = 120; // 21
        int x3 = 1534236469; // 0
        System.out.println(reverse(x3));
    }

    static int reverse(int x) {
        long result = 0;
        while (x != 0) {
            // Get the last digit of given number
            int lastDigit = x % 10;
            // Add the last digit to the result number
            result = result * 10 + lastDigit;
            // Divide the given number to 10
            x /= 10;
        }
        // If the result out of Integer range -> return 0
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) result;
    }
}
