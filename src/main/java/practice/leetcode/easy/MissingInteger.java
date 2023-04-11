package practice.leetcode.easy;

/**
 * @author LucasBV
 */
public class MissingInteger {

    /*
    Find the missing integer in the given array
    {1,2,3,4,1} return 5
    {-1,-2} return 1
    {1,3,2,1,5} return 4
     */
    public static void main(String[] args) {
        // Find the missing integer in the array
        int[] arr = new int[]{1, 2, 3, 4, 1};
        System.out.println("result:" + missingInt(arr));
    }

    static int missingInt(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        // create temp array to remove duplicate
        int[] tarr = new int[n];
        int k = 0;
        for (int i = 0; i < n - 1; i++) {
            // if not duplicate then add to temp array
            if (arr[i] != arr[i + 1]) {
                tarr[k++] = arr[i];
            }
        }
        tarr[k++] = arr[n - 1];
        System.arraycopy(tarr, 0, arr, 0, k);

        // use new array to find missing int
        for (int i = 0; i < n - 1; i++) {
            if (arr[i + 1] != (arr[i] + 1)) {
                return arr[i] + 1;
            }
        }
        return 1;
    }
}
