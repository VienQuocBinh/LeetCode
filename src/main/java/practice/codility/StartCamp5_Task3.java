package practice.codility;

/*
Max number of non-intersecting elements of len = 2 having same sum. (OA LeetCode)
You are given an array A of integers. Find the maximum number of non-intersecting segments of length 2 (two adjacent elements), such that segments have an equal sum.
For example, given A = [10, 1, 3, 1, 2, 2, 1, 0, 4], there are three non-intersecting segments, each whose sum is equal to 4: (1, 3), (2, 2), (0, 4). Another three non-intersecting segments are: (3, 1), (2, 2), (0, 4).
Write a function:
class Solution { public int solution(int[] A); }
that, given an array A of N integers, returns the maximum number of segments with equal sums.
Examples:
1. Given A = [10, 1, 3, 1, 2, 2, 1, 0, 4], the function should return 3, as explained above.
2. Given A = [5, 3, 1, 3, 2, 3], the function should return 1. Each sum of two adjacent elements is different from the others.
3. Given A = [9, 9, 9, 9, 9], the function should return 2.
4. Given A = [1, 5, 2, 4, 3, 3], the function should return 3. There are three segments: (1, 5), (2, 4), (3, 3) whose sums are equal to 6. Write an efficient algorithm for the following assumptions:
• N is an integer within the range [2..100,000];
• each element of array A is an integer within the range [0..1,000,000,000].
 */
public class StartCamp5_Task3 {
    public static void main(String[] args) {
        int[] A1 = {10, 1, 3, 1, 2, 2, 1, 0, 4};
        int[] A2 = {5, 3, 1, 3, 2, 3};
        int[] A3 = {9, 9, 9, 9, 9};
        int[] A4 = {1, 5, 2, 4, 3, 3};

        System.out.println(solution(A1));  // Output: 3
        System.out.println(solution(A2));  // Output: 1
        System.out.println(solution(A3));  // Output: 2
        System.out.println(solution(A4));  // Output: 3
    }


    public static int solution(int[] A) {
        int n = A.length;
        int pairs = 0;
        for (int i = 0; i < n - 1; i++) {
            int sum = A[i] + A[i + 1];
            pairs = Math.max(pairs, 1 + countNonIntersectingPair(i + 2, sum, A));
        }
        return pairs;
    }

    private static int countNonIntersectingPair(int i, int sum, int[] A) {
        int n = A.length;
        if (i > n - 2) {
            return 0;
        }
        int count = 0;
        if (A[i] + A[i + 1] == sum) {
            count = 1 + countNonIntersectingPair(i + 2, sum, A);

        }
        return Math.max(count, countNonIntersectingPair(i + 1, sum, A));
    }
}
