package practice.leetcode.medium;

/*
A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.

Example 1:
Input: nums = [1,2,3]
Output: [1,3,2]

Example 2:
Input: nums = [3,2,1]
Output: [1,2,3]

Example 3:
Input: nums = [1,1,5]
Output: [1,5,1]
 */
public class NextPermutation {
    public static void main(String[] args) {
//        int[] nums = new int[]{1, 2, 3}; // 132
        int[] nums = new int[]{1, 3, 2}; // 213

        nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    static void nextPermutation(int[] nums) {
        int breakPoint = -1;
        int greaterIndex = -1;
        // Find the break point: the index of the smaller value of 2 adjacent indexes. Loop from the back.
        // e.g: [1,2,3] -> breakPoint = 1
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                breakPoint = i;
                break;
            }
        }

        // If we do not find any break point (breakPoint == -1). The array is DESC ordered. -> Reverse the whole array
        if (breakPoint == -1) {
            reverse(nums, 0, nums.length - 1);
        } else {
            // If we do find a break point -> Find the index of the first value that greater than the value at breakPoint index
            for (int i = nums.length - 1; i >= breakPoint; i--) {
                if (nums[i] > nums[breakPoint]) {
                    greaterIndex = i;
                    break;
                }
            }
            // e.g: [1,2,3] -> breakPoint = 1, greaterIndex = 2
            swap(nums, breakPoint, greaterIndex); // swap 2 values at breakPoint index and greaterIndex index ([1,3,2])

            reverse(nums, breakPoint + 1, nums.length - 1); // reverse the right half array from breakPoint+1 to end
        }

    }

    static void reverse(int[] nums, int fromIndex, int toIndex) {
        while (fromIndex < toIndex) {
            swap(nums, fromIndex, toIndex);
            fromIndex++;
            toIndex--;
        }
    }

    static void swap(int[] nums, int fromIndex, int toIndex) {
        int temp = nums[fromIndex];
        nums[fromIndex] = nums[toIndex];
        nums[toIndex] = temp;
    }
}
