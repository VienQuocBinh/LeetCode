package practice.leetcode.easy;

/*
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:
Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.

Example 2:
Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.
 */
public class FindFirstOccurrenceIndexInAString {
    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issip"; // 4
//        String needle = "issipi"; // -1
//        String haystack = "sadbutsad";
//        String needle = "sad"; // 0
//        String haystack = "leetcode";
//        String needle = "leeto"; // -1
//        String haystack = "aaa";
//        String needle = "aaaa"; // -1
        System.out.println(strStr(haystack, needle));
    }

    static int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) return -1;
        int index = -1;
        for (int i = 0; i < haystack.length(); i++) {
            int tempIndex = i;
            // Loop through each character of needle string
            for (int j = 0; j < needle.length(); j++) {
                // If char of haystack equals needle string -> check the next char index of both strings
                // Else break loop
                if (tempIndex < haystack.length() && haystack.charAt(tempIndex) == needle.charAt(j)) {
                    tempIndex++;
                    index = i;
                } else {
                    index = -1;
                    break;
                }
                // Found the match string index -> return the first index
                if (j == needle.length() - 1) {
                    return index;
                }
            }
        }
        return index;
    }
}
