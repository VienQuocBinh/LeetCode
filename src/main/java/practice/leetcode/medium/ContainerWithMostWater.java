package practice.leetcode.medium;

/*
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Example 1:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

Example 2:
Input: height = [1,1]
Output: 1
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] height1 = new int[]{1, 1};
        System.out.println(maxArea(height1));
    }

    static int maxArea(int[] height) {
        int max = 0, left = 0, right = height.length - 1;
        while (left < right) {
            int area;
            if (height[left] > height[right]) {
                area = height[right] * (right - left);
                right--;
            } else if (height[left] < height[right]) {
                area = height[left] * (right - left);
                left++;
            } else {
                area = height[left] * (right - left);
                if (height[left + 1] < height[right - 1]) {
                    left++;
                } else {
                    right--;
                }
            }
            if (area > max) {
                max = area;
            }
        }
        return max;
    }
}
