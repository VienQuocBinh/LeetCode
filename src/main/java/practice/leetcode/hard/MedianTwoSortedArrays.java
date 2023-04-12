package practice.leetcode.hard;

public class MedianTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0, k = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;
        int[] arr = new int[n];
        // Merge 2 sorted arrays
        while (i < n1 && j < n2) {
            if (nums1[i] < nums2[j]) {
                arr[k] = nums1[i];
                k++;
                i++;
            } else {
                arr[k] = nums2[j];
                k++;
                j++;
            }
        }

        // Add the remaining elements of the array 1 (if any)
        while (i < n1) {
            arr[k] = nums1[i];
            i++;
            k++;
        }
        // Add the remaining elements of the array 2 (if any)
        while (j < n2) {
            arr[k] = nums2[j];
            j++;
            k++;
        }
        if (n % 2 == 0) return (double) (arr[n / 2] + arr[n / 2 - 1]) / 2;
        return arr[n / 2];
    }
}
