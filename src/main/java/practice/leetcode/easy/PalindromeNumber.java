package practice.leetcode.easy;

public class PalindromeNumber {
    /*
    Số đối xứng
     */
    public static void main(String[] args) {
        System.out.println(isPalindrome(-127));
    }

    static boolean isPalindrome(int n) {
        boolean result = false;
        if (n < 0) return false;
        String num = String.valueOf(n);
        for (int i = 0, j = num.length() - 1; j >= i; i++, j--) {
            if (num.charAt(j) != num.charAt(i)) return false;
        }

        return true;
    }
}
