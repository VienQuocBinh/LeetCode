package practice.leetcode.medium;

/*
There is an integer array nums sorted in ascending order (with distinct values).
Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

Example 3:
Input: nums = [1], target = 0
Output: -1
 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int target = 0;//4
//        int[] nums = new int[]{1, 3};
//        int target = 3; //1
//        int[] nums = new int[]{3, 5, 1};
//        int target = 3; //0
        System.out.println(search(nums, target));
    }

    static int search(int[] nums, int target) {
        // Using binary search but not in the sorted order for the whole array just the half
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // If left -> mid is in the sorted array -> search the left sorted array
            // else mid -> right is in the sorted array -> search the right sorted array
            if (nums[left] <= nums[mid]) {
                // If the target in range left to mid
                // else the target in range mid to right
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // focus on the left side (left to mid)
                } else {
                    left = mid + 1; // focus on the right side (mid to right)
                }
            } else {
                // If the target in range mid to right
                // else the target in range left to mid
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // focus on the right side (mid to right)
                } else {
                    right = mid - 1; // focus on the left side (left to mid)
                }
            }
        }
        return -1;
    }
}
