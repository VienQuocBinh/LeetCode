package practice.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
Return k.
Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.
Example 1:
Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).

Example 2:
Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        System.out.println(removeDuplicates(nums));
    }

    static int removeDuplicates(int[] nums) {
        int j = 1; // The number of unique elements
        for (int i = 1; i < nums.length; i++) {
            // If different -> brings the elements at i to j, increase j
            // else just increase i
            if (nums[i] != nums[i - 1]) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    static int removeDuplicatesApproach1(int[] nums) {
        int temp = nums[0];
        int dup = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == temp && i != 0) {
                dup++;
            } else {
                temp = num;
                result.add(num);
            }
        }

        int uniqueElements = nums.length - dup;
        nums = new int[uniqueElements];
        for (int i = 0; i < nums.length; i++) {
            int num = result.get(i);
            nums[i] = num;
        }

        return uniqueElements;
    }
}
