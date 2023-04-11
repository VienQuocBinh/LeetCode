package practice.leetcode.easy;

/**
 * Example 1:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * <p>
 * Example 2:
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "flight"}; // fl
        String[] strs2 = new String[]{"dog", "racecar", "car"}; // ""
        System.out.println(longestCommonPrefix(strs2));
    }

    static String longestCommonPrefix(String[] strs) {
        String common = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(common)) {
                common = common.substring(0, common.length() - 1);
            }
        }
        return common;
    }
}
