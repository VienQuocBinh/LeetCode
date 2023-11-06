package practice.codility;

/*
An array A consisting of N different integers is given.
The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.
Your goal is to find that missing element.
Write a function:
class Solution { public int solution(int[] A); }
that, given an array A, returns the value of the missing element.

For example, given array A such that:
  A[0] = 2
  A[1] = 3
  A[2] = 1
  A[3] = 5
the function should return 4, as it is the missing element.

Write an efficient algorithm for the following assumptions:
N is an integer within the range [0..100,000];
the elements of A are all distinct;
each element of array A is an integer within the range [1..(N + 1)].
 */
public class PermutationMissingElement {
    public static void main(String[] args) {
        int[] A = new int[]{2, 3, 1, 5}; // 4
//        int[] A = new int[]{1}; // 2
//        int[] A = new int[]{}; // 1
//        int[] A = new int[]{2, 3, 4, 5}; // 1
//        int[] A = new int[]{2, 3, 4, 1}; // 5

        System.out.println(solution(A));
    }

    static int solution(int[] A) {
        int length = A.length;
        int expectedSum = (length + 1) * (length + 2) / 2; // expected sum from 1 to n + 1
        int actualSum = 0;
        for (int i : A) {
            actualSum += i;
        }
        return expectedSum - actualSum;
    }
}
