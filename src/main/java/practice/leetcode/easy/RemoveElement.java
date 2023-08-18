package practice.leetcode.easy;

public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 2, 3};
        int val = 3;
        System.out.println(removeElement(nums, val));
    }

    static int removeElement(int[] nums, int val) {
        int j = 0; // The number of elements not equal to val
        for (int i = 0; i < nums.length; i++) {
            // If equal to val -> brings the elements at i to j, increase j
            // else just increase i
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        for (int num : nums) {
            System.out.print(" " + num);
        }
        return j;
    }
}
