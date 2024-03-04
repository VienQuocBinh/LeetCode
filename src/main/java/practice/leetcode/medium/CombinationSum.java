package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
