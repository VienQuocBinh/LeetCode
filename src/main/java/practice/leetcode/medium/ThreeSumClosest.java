package practice.leetcode.medium;

import java.util.Arrays;

/*
Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
Return the sum of the three integers.

Example 1:
Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

Example 2:
Input: nums = [0,0,0], target = 1
Output: 0
Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
//        int[] nums = new int[]{-1, 2, 1, -4};
//        int target = 1;

//        int[] nums = new int[]{0, 0, 0};
//        int target = 1;

        int[] nums = new int[]{1, 1, 1, 0};
        int target = 100;
//        int target = -100;
        System.out.println(threeSumClosest(nums, target));
    }

    static int threeSumClosest(int[] nums, int target) {
        int minDiff = Integer.MAX_VALUE;
        int closestSum = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) return sum;
                int diff = Math.abs(sum - target);
                if (diff < minDiff) {
                    minDiff = diff;
                    closestSum = sum;
                }
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return closestSum;
    }
}
