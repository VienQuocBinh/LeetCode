package practice.leetcode.hard;

/*
Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

Example 1:
Input: nums = [1,2,0]
Output: 3
Explanation: The numbers in the range [1,2] are all in the array.

Example 2:
Input: nums = [3,4,-1,1]
Output: 2
Explanation: 1 is in the array but 2 is missing.

Example 3:
Input: nums = [7,8,9,11,12]
Output: 1
Explanation: The smallest positive integer 1 is missing.

Constraints:
1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = new int[]{7, 8, 9, 11, 12};
        System.out.println(firstMissingPositive(nums));
    }

    /*
    Positive integer is >= 1
    -> The structure of array must be [1, 2, 3, ...]
    -> The key - value (correctIndex, value): (0, 1), (1, 2), (2, 3) ... (correctIndex, value - 1)
    -> Loop from the start of the array, if any index != value at that index - 1
    -> Return the missing positions = (index + 1) or (n + 1) if the array is sorted from 1 to n.
     */
    static int firstMissingPositive(int[] nums) {
        int i = 0;
        // Arrange the elements in the correct place [3, 4, -1, 1] -> [1, 4, 3, -1]
        while (i < nums.length) {
            int correctIndex = nums[i] - 1; // Find the correct index to swap
            // Swap only the positive value, the value less than the array length and different from the value in the correct index
            if (nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[correctIndex]) {
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else {
                i++;
            }
        }
        // Loop from the start of the array, if any index != value at that index - 1
        // -> Return the missing positions = index + 1.
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] - 1 != j) return j + 1;
        }
        return nums.length + 1;
    }
}
