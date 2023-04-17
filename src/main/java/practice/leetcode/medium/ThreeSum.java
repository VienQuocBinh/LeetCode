package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
//        int[] sums = new int[]{-1, 0, 1, 2, -1, -4};
//        int[] sums = new int[]{0, 1, 1};
//        int[] sums = new int[]{0, 0, 0};
        int[] sums = new int[]{1, -1, -1, 0};
        for (List<Integer> integers : threeSum(sums)) {
            for (Integer integer : integers)
                System.out.print(integer);
            System.out.println();
        }
    }

    static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Sort arrays in ascending order
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int left = i + 1;
                int right = nums.length - 1;
                // Iterate over the rest of the array from the left to the right index
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum == 0) {
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        // Remove duplicate numbers
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    } else if (sum < 0) {
                        // If sum < 0 (need to increase left index to get the larger value)
                        left++;
                    } else {
                        // If sum > 0 (need to decrease right index to get the smaller value)
                        right--;
                    }
                }
            }
        }

        return result;
    }
}
