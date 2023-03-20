package practice.leetcode.medium;

/**
 * @author LucasBV
 */
public class BattleShip {

    public static void main(String[] args) {
//        String[] B = {".##.#","#.#..","#...#","#.##."}; // 212
//        String[] B = {"##.", "#.#", ".##"}; // 002
        String[] B = {".#..#", "##..#", "...#."}; // 111

        int[] R = new int[]{0, 0, 0};

        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[i].length(); j++) {
                if (B[i].charAt(j) == '#') {
                    int type = find(B, i, j);
                    switch (type) {
                        case 1 -> R[0]++;
                        case 2 -> R[1]++;
                        case 3 -> R[2]++;
                        default -> {
                        }
                    }
                }
            }
        }

        for (int i = 0; i < R.length; i++) {
            System.out.print(R[i]);
        }
    }

    private static int find(String[] arr, int i, int j) {
        int n = 1;
        arr[i] = arr[i].substring(0, j) + " " + arr[i].substring(j + 1);
        if (j < arr[i].length() - 1 && arr[i].charAt(j + 1) == '#') {
            return find(arr, i, j + 1) + find(arr, i, j);
        } else if (i < arr.length - 1 && arr[i + 1].charAt(j) == '#') {
            return find(arr, i + 1, j) + find(arr, i, j);
        } else if (j > 0 && arr[i].charAt(j - 1) == '#') {
            return find(arr, i, j - 1) + find(arr, i, j);
        }
        return n;
    }
}
