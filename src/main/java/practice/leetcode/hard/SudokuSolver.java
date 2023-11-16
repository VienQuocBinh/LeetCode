package practice.leetcode.hard;

import java.util.HashSet;
import java.util.Set;

public class SudokuSolver {
    private static final boolean[][] modifiable = new boolean[9][9];
    private static final int[][] result = new int[9][9];

    public static void main(String[] args) {
//        String[][] stringBoard = {
//                {"5", "3", ".", ".", "7", ".", ".", ".", "."},
//                {"6", ".", ".", "1", "9", "5", ".", ".", "."},
//                {".", "9", "8", ".", ".", ".", ".", "6", "."},
//                {"8", ".", ".", ".", "6", ".", ".", ".", "3"},
//                {"4", ".", ".", "8", ".", "3", ".", ".", "1"},
//                {"7", ".", ".", ".", "2", ".", ".", ".", "6"},
//                {".", "6", ".", ".", ".", ".", "2", "8", "."},
//                {".", ".", ".", "4", "1", "9", ".", ".", "5"},
//                {".", ".", ".", ".", "8", ".", ".", "7", "9"}
//        };
        String[][] stringBoard = {
                {".", ".", "9", "7", "4", "8", ".", ".", "."},
                {"7", ".", ".", ".", ".", ".", ".", ".", "."},
                {".", "2", ".", "1", ".", "9", ".", ".", "."},
                {".", ".", "7", ".", ".", ".", "2", "4", "."},
                {".", "6", "4", ".", "1", ".", "5", "9", "."},
                {".", "9", "8", ".", ".", ".", "3", ".", "."},
                {".", ".", ".", "8", ".", "3", ".", "2", "."},
                {".", ".", ".", ".", ".", ".", ".", ".", "6"},
                {".", ".", ".", "2", "7", "5", "9", ".", "."}
        };
        char[][] board = new char[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = stringBoard[i][j].charAt(0);
            }
        }
        solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    static void solveSudoku(char[][] board) {
        markModifiable(board);
        recursive(0);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.toString(result[i][j]).charAt(0);
            }
        }
    }

    static void markModifiable(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                modifiable[i][j] = board[i][j] == '.';
                if (!modifiable[i][j]) {
                    result[i][j] = Integer.parseInt(String.valueOf(board[i][j]));
                }
            }
        }
    }

    static boolean recursive(int idx) {
        if (idx == 81) return true;
        int row = idx / 9;
        int col = idx % 9;
        // Try the value 1-9 for this cell
        for (int candidate = 1; candidate < 10; candidate++) {
            // If this cell is empty, set the candidate and check the result is still valid
            if (modifiable[row][col]) {
                result[row][col] = candidate;
                if (isValidSudoku(result) && recursive(idx + 1)) {
                    return true;
                }
            } else {
                return recursive(idx + 1);
            }
        }
        // If still not find the suitable candidate for the cell, erase the candidate from the result
        result[row][col] = 0;
        return false;
    }

    static boolean isValidSudoku(int[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Integer> row = new HashSet<>();
            Set<Integer> col = new HashSet<>();
            Set<Integer> box = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                // Check row
                if (board[i][j] != 0 && !row.add(board[i][j])) return false;
                // Check col
                if (board[j][i] != 0 && !col.add(board[j][i])) return false;
                // Check 3x3 box
                int rowIndex = 3 * (i / 3); // the first row of each box
                int colIndex = 3 * (i % 3); // the first column of each box
                int cell = board[rowIndex + j / 3][colIndex + j % 3];
                if (cell != 0 && !box.add(cell)) return false;
            }
        }
        return true;
    }
}
