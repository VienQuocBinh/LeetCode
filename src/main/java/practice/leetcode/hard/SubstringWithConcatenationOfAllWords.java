package practice.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
You are given a string s and an array of strings words. All the strings of words are of the same length.

A concatenated substring in s is a substring that contains all the strings of any permutation of words concatenated.

For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not a concatenated substring because it is not the concatenation of any permutation of words.
Return the starting indices of all the concatenated substrings in s. You can return the answer in any order.

Example 1:
Input: s = "barfoothefoobarman", words = ["foo","bar"]
Output: [0,9]
Explanation: Since words.length == 2 and words[i].length == 3, the concatenated substring has to be of length 6.
The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.
The output order does not matter. Returning [9,0] is fine too.

Example 2:
Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
Output: []
Explanation: Since words.length == 4 and words[i].length == 4, the concatenated substring has to be of length 16.
There is no substring of length 16 is s that is equal to the concatenation of any permutation of words.
We return an empty array.

Example 3:
Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
Output: [6,9,12]
Explanation: Since words.length == 3 and words[i].length == 3, the concatenated substring has to be of length 9.
The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"] which is a permutation of words.
The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"] which is a permutation of words.
The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"] which is a permutation of words.
 */
public class SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        String s1 = "barfoothefoobarman";
        String[] words1 = {"foo", "bar"};
        System.out.println(findSubstring(s1, words1));  // Output: [0, 9]

        String s2 = "wordgoodgoodgoodbestword";
        String[] words2 = {"word", "good", "best", "word"};
        System.out.println(findSubstring(s2, words2));  // Output: []

        String s3 = "barfoofoobarthefoobarman";
        String[] words3 = {"bar", "foo", "the"};
        System.out.println(findSubstring(s3, words3));  // Output: [6, 9, 12]
    }

    static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.isEmpty() || words == null || words.length == 0) return result;
        int wordLength = words[0].length();
        int totalWords = words.length;
        int concatLength = wordLength * totalWords;

        // Count the occurrence of words in the array
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLength; i++) {
            int left = i;
            int right = i;
            Map<String, Integer> window = new HashMap<>(); // temporary array
            // Loop until the last word
            while (right + wordLength <= s.length()) {
                String word = s.substring(right, right + wordLength);
                right += wordLength;

                // The word is contained in the words array
                if (wordCount.containsKey(word)) {
                    // Put the word and increase its occurrences by 1
                    window.put(word, window.getOrDefault(word, 0) + 1);
                    // Loop while the occurrences of seen words are more than the needed words
                    // Compare the occurrences of the words in window and wordCount map
                    while (window.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLength); // Get the left word
                        window.put(leftWord, window.get(leftWord) - 1); // Decrease the occurrences of the left word by 1
                        left += wordLength; // Move left to 1 word length
                    }
                    // If you find the matching length -> add it to the result
                    if (right - left == concatLength) result.add(left);
                } else {
                    // The word is not contained in the words array -> clear all the seen words in a temporary array
                    window.clear();
                    left = right;
                }
            }
            window.clear();
        }
        return result;
    }
}
