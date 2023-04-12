package practice.leetcode.medium;

/*
Example 1:
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
P   A   H   N
A P L S I I G
Y   I   R
The string "PAHNAPLSIIGYIR" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

Example 2:
Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
 */
public class ZigzagConversion {
    public static void main(String[] args) {
        String s1 = "PAYPALISHIRING";
        int n1 = 3; // "PAHNAPLSIIGYIR"
        int n2 = 4; // "PINALSIGYAHRPI"
        System.out.println(convert(s1, n2));
    }

    static String convert(String s, int numRows) {
        // If only one row -> return that row
        if (numRows == 1) return s;

        StringBuilder[] convertedString = new StringBuilder[numRows];
        // initialize rows
        for (int i = 0; i < numRows; i++) {
            convertedString[i] = new StringBuilder();
        }

        int rowIdx = 0, direction = -1;
        // Loop through the characters in the input string
        for (char c : s.toCharArray()) {
            // Append each character to the appropriate row of the converted string
            convertedString[rowIdx].append(c);
            // Reverse the movement direction whenever reached the top and bottom row
            if (rowIdx == 0 || rowIdx == numRows - 1) direction *= -1;
            rowIdx += direction;
        }

        // Concatenate all rows of the converted string
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : convertedString)
            result.append(row);

        // Print the matrix
        System.out.println("*** Matrix after conversion:");
        for (int i = 0; i < numRows; i++) {
            String row = convertedString[i].toString();
            System.out.println(row);
        }


        System.out.println("*** String after conversion:");
        return result.toString();
    }
}
