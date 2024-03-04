package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
frequency of at least one of the chosen numbers is different.
The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

Example 1:
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

Example 2:
Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]

Example 3:
Input: candidates = [2], target = 1
Output: []
 */
public class CombinationSum {
    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = combinationSum(arr, target);
        result.forEach(r -> System.out.println(Arrays.toString(r.toArray())));
    }

    static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        backtrackingFindCombination(0, target, candidates, list, new ArrayList<>());
        return list;
    }

    private static void backtrackingFindCombination(int index, int target, int[] arr, List<List<Integer>> answer, List<Integer> temp) {
        // Base case (start index in the last element)
        if (index == arr.length) {
            // Add to result if the sum of temp list is equal to the target
            if (target == 0)
                answer.add(new ArrayList<>(temp));
            return;
        }
        // Recursive case
        if (arr[index] <= target) {
            temp.add(arr[index]); // Add the int number to the temp list
            backtrackingFindCombination(index, target - arr[index], arr, answer, temp);
            temp.remove(temp.size() - 1); // Remove the last number from the temp list if not necessary
        }
        backtrackingFindCombination(index + 1, target, arr, answer, temp); // Move the start index to the next number
    }
}
