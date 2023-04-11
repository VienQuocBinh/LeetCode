package practice.leetcode.medium;

public class LongestPalindromic {
    public static void main(String[] args) {
        String s1 = "babad"; // "bab" || "aba"
        String s2 = "cbbd"; // "bb"
        String s3 = "ccc"; // "ccc"
        System.out.println(longestPalindromicString(s1));
    }

    static String longestPalindromicString(String s) {
        String result = "";
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            int odd = expandedPalindromicStringLength(s, i, i); // For palindromic strings has odd length
            int even = expandedPalindromicStringLength(s, i, i + 1); // For palindromic strings has even length
            if (Math.max(odd, even) > maxLength) {
                maxLength = Math.max(odd, even);
                result = s.substring(i - (maxLength - 1) / 2, i + maxLength / 2 + 1);
            }
        }
        return result;
    }

    /**
     * Get the length of the palindromic string from the center index expanded to 2 sides (left, right)
     *
     * @param s     {@code String}
     * @param left  {@code int}
     * @param right {@code int}
     * @return {@code  int}
     */
    static int expandedPalindromicStringLength(String s, int left, int right) {
        int length = 0;
        while (right < s.length() && left >= 0 && s.charAt(left) == s.charAt(right)) {
            if (right - left + 1 > length) {
                length = right - left + 1;
            }
            right++;
            left--;
        }
        return length;
    }
}
