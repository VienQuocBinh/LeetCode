package practice.leetcode.medium;

public class DivideTwoInteger {
    public static void main(String[] args) {
        int dividend = 10;
        int divisor = 3;
        System.out.println(divide(dividend, divisor));
    }

    static int divide(int dividend, int divisor) {
        // Handle overflow and special cases
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        // Determine the sign of the result
        boolean positive = (dividend >= 0) == (divisor >= 0);
        // Convert both dividend and divisor to positive values
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        long quotient = 0;

        // Perform the division
        while (absDividend >= absDivisor) {
            long temp = absDivisor;
            long multiple = 1;
            while (absDividend >= (temp << 1)) {
                temp <<= 1; // increase temp to 2*temp
                multiple <<= 1; // increase multiple to 2*multiple
            }
            absDividend -= temp;
            quotient += multiple;
        }

        // Apply the sign
        if (!positive)
            quotient = -quotient;

        // Handle integer range constraints
        if (quotient > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) quotient;
    }
}
