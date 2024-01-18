package practice.fsoft;

/*
Between 2 odd chars then add '-' between them
Between 2 even chars then add '*' between them

 */
public class DashInsert2 {
    public static void main(String[] args) {
        System.out.println(dashInsert2(99946));
//                // Test cases
//                System.out.println(dashInsertII("4546793"));  // Output: 454*67-9-3
//                System.out.println(dashInsertII("99946"));     // Output: 9-9-94*6
//                System.out.println(dashInsertII("56647304"));  // Output: 56*6*47-304
    }

    //    public static int dashInsert2(int str)
    public static String dashInsert2(int num) {
        String str = String.valueOf(num);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length() - 1; i++) {
            char currentChar = str.charAt(i);
            char nextChar = str.charAt(i + 1);
            result.append(currentChar);
            int currentDigit = Character.getNumericValue(currentChar);
            int nextDigit = Character.getNumericValue(nextChar);
            if (currentDigit != 0 && nextDigit != 0) {
                if (currentDigit % 2 == 0 && nextDigit % 2 == 0) {
                    result.append('*');
                } else if (currentDigit % 2 != 0 && nextDigit % 2 != 0) {
                    result.append('-');
                }
            }
        }
        result.append(str.charAt(str.length() - 1)); // Add the last character
        return result.toString();
    }
}
