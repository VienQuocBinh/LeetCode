package practice.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Example 1:
 * <p>
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
        System.out.println(longestSubstringWithoutRepeatingCharactersLength(s3));
    }

    static int longestSubstringWithoutRepeatingCharactersLength(String s) {
        int len = 0;
        int left = 0;
        Set<Character> set = new HashSet<>();
        // Loop through all characters
        for (int right = 0; right < s.length(); right++) {
            // If this character doesn't have in the set -> add it to the set
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                len = Math.max(len, right - left + 1);
            } else {
                // If this character already has in the set
                // -> remove the different char from the left until we find the same character
                while (s.charAt(left) != s.charAt(right)) {
                    set.remove(s.charAt(left));
                    left++;
                }
                // Remove the same character from the left
                set.remove(s.charAt(left));
                left++;
                // Add the next character
                set.add(s.charAt(right));

            }
        }
        return len;
    }
}
