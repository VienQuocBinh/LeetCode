package practice.leetcode.medium;


import java.util.*;

/*
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

Example 1:
Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

Example 2:
Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
 */
public class FourSum {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 2, 2, 2};
        int target = 8;
//        int[] nums = new int[]{1000000000, 1000000000, 1000000000, 1000000000};
//        int target = -294967296; // [[]]
        for (List<Integer> quadruplet : fourSum(nums, target)) {
            System.out.println(quadruplet);
        }
    }

    static List<List<Integer>> fourSum(int[] nums, int target) {
        // Using set to avoid duplicates quadruplet
        Set<List<Integer>> quadruplets = new HashSet<>();
        // Sort the given array in ascending order
        Arrays.sort(nums);
        // Set 4 indexes to find the quadruplet (i j left right)
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    // Split the sum operation because of the very big integer can not represent in 32-bit words
                    long sum = nums[i] + nums[j];
                    sum += nums[left];
                    sum += nums[right];
                    if (sum == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                    } else if (sum < target) {
                        // If the sum < target increases the index to get the larger number
                        left++;
                    } else {
                        // If the sum > target decreases the index to get the smaller number
                        right--;
                    }
                }
            }
        }
        return new ArrayList<>(quadruplets);
    }
}
