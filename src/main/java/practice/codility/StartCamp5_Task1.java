package practice.codility;

/*
Write a function solution that, given a string S consisting of N characters, returns the alphabetically smallest string that can be obtained by removing exactly one letter from S.
Examples:
1. Given S = "acb", by removing one letter, you can obtain "ac", "ab" or "cb". Your function should return "ab" (after removing 'c') since it is alphabetically smaller than "ac" and "bc".
2. Given S = "hot", your function should return "ho", which is alphabetically smaller than "ht" and "ot".
3. Given S = "codility", your function should return "cdility", which can be obtained by removing the second letter.
4. Given S = "aaaa", your function should return "aaa". Any occurrence of 'a' can be removed.
Write an efficient algorithm for the following assumptions:
N is an integer within the range [2..100,000];
string S is made only of lowercase letters (a-z).
 */
public class StartCamp5_Task1 {
    public static void main(String[] args) {
        String s = "codility";
        System.out.println(solution(s));
    }

    static String solution(String S) {
        int n = S.length();
        String smallest = S;

        for (int i = 0; i < n; i++) {
            StringBuilder stringBuilder = new StringBuilder(S);
            stringBuilder.deleteCharAt(i);
            String modifiedStr = stringBuilder.toString();
            if (modifiedStr.compareTo(smallest) < 0) {
                smallest = modifiedStr;
            }
        }
        return smallest;
    }
}
