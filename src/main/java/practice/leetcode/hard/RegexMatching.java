package practice.leetcode.hard;

/*
Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).
*/
/*
Example 1:
Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
(Horizontal: pattern; vertical: string text)
    0   a
0   T   F
a   F   T (top-left diagonal)
a   F   = F (top-left diagonal)
-> return dp[i][j] = false
*/
/*
Example 2:
Input: s = "aa", p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
(Horizontal: pattern; vertical: string text)
    0   a                       *
0   T   F                       T
a   F   T (top-left diagonal)   F || T = T
a   F   F (top-left diagonal)   F || T = T
-> return dp[i][j] = true
*/
/*
Example 3:
Input: s = "ab", p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
(Horizontal: pattern; vertical: string text)
    0   .                       *
0   T   T (top-left diagonal)   T || T = T
a   F   T (top-left diagonal)   F || T = T
a   F   F (top-left diagonal)   F || T = T
-> return dp[i][j] = true
 */
public class RegexMatching {
    public static void main(String[] args) {
//        String s = "aa", p = "a"; // false
//        String s = "aa", p = "a*"; // true
        String s = "ab", p = ".*"; // true
        System.out.println(isMatch(s, p));
    }

    /*
    dp[i][j] =
        if(s[i] == p[j] || p[j] == '.') -> dp[i-1][j-1]  (Look for the diagonal value to the top left);
        if(p[j] = '*') =
            dp[i][j-2] (left 2 index) ||
            if(p[j-1] == '.' || s[i] == p[j-1]) dp[i-1][j] (up 1 index);
        else false;
     */
    static boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        // represent whether substring of 's' from index 0 to i-1 matches
        // substring of 'p' from index 0 to j-1
        boolean[][] dp = new boolean[n + 1][m + 1];

        dp[0][0] = true; // empty string matches empty pattern
        // Fill in dynamic programming array in bottom-up
        // Fill the first row to handle pattern starting with '*' (a* or a*b* or a*b*c*)
        for (int j = 1; j <= m; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        // Fill in the rest of the array
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // If char of 's' matches char of 'p' -> move to the next index of both 's' and 'p'
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1]; // Look for the diagonal value to the top left
                } else if (p.charAt(j - 1) == '*') {
                    // If '*' is used to match char 0 occurrences of the preceding character in 'p' -> move to the next char in the 'p'
                    // Set the value at dp[i][j - 2] -> j - 2
                    dp[i][j] = dp[i][j - 2];
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        // If '*' is used to match char 1 or more occurrences of the preceding character in 'p'
                        // Move to the next char of the 's'
                        dp[i][j] |= dp[i - 1][j]; // bitwise OR: update dp[i][j] base on the result of dp[i-1][j]
                    }
                }
            }
        }
        return dp[n][m];
    }
}
