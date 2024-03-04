package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
Each number in candidates may only be used once in the combination.
Note: The solution set must not contain duplicate combinations.

Example 1:
Input: candidates = [10,1,2,7,6,1,5], target = 8
Output:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]

Example 2:
Input: candidates = [2,5,2,1,2], target = 5
Output:
[
[1,2,2],
[5]
]

Constraints:
1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30
 */
public class CombinationSum2 {
    public static void main(String[] args) {
        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> result = combinationSum(arr, target);
        result.forEach(r -> System.out.println(Arrays.toString(r.toArray())));
    }

    static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        backtrackingFindCombination(0, target, Arrays.stream(candidates).sorted().toArray(), list, new ArrayList<>());
        return list;
    }

    // Optimize method
    private static void backtrackingFindCombination(int index, int target, int[] arr, List<List<Integer>> answer, List<Integer> temp) {
        // Base case (start index in the last element)
        if (target == 0) {
            answer.add(new ArrayList<>(temp));
            return;
        }
        // Loop from the start index, ignore the previous elements before start index
        for (int i = index; i < arr.length && arr[i] <= target; i++) {
            // Remove duplicates
            if (i > index && arr[i] == arr[i - 1]) continue;
            temp.add(arr[i]);
            backtrackingFindCombination(i + 1, target - arr[i], arr, answer, temp);
            temp.remove(temp.size() - 1);
        }
    }

    // Legacy from the CombinationSum solution
    private static void backtrackingFindCombination2(int index, int target, int[] arr, List<List<Integer>> answer, List<Integer> temp) {
        // Base case (start index in the last element)
        if (index == arr.length) {
            if (target == 0) {
                answer.add(new ArrayList<>(temp));
            }
            return;
        }
        // Recursive case
        if (arr[index] <= target) {
            temp.add(arr[index]); // Add the int number to the temp list
            backtrackingFindCombination(index + 1, target - arr[index], arr, answer, temp); // increase start index by 1
            temp.remove(temp.size() - 1); // Remove the last number from the temp list if not necessary
        }
        // Remove duplicates
        int j = index + 1;
        while (j < arr.length && arr[j] == arr[j - 1]) j++;
        backtrackingFindCombination(j, target, arr, answer, temp);
    }
}
