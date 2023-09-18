package practice.leetcode.medium;

import java.util.Arrays;

/*

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example 3:
Input: nums = [], target = 0
Output: [-1,-1]
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 8; // [3, 4]
//        int[] nums = new int[]{};
//        int target = 0; // [-1, -1]
//        int[] nums = new int[]{1};
//        int target = 1; // [0, 0]
//        int[] nums = new int[]{1, 3};
//        int target = 1; // [0, 0]
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    static int[] searchRange(int[] nums, int target) {
        int start = -1;
        int end = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] != target) {
                left++;
            } else {
                start = left;
            }
            if (nums[right] != target) {
                right--;
            } else {
                end = right;
            }
            if (start != -1 && end != -1) break;
        }
        return new int[]{start, end};
    }
}
