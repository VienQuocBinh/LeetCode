package practice.fsoft;

public class ConsonantCount {
    public static void main(String[] args) {

        String s1 = "Hello World";
        String s2 = "Alphabets";
        System.out.println(consonantCount(s2));
    }

    public static String consonantCount(String str) {
        String vowels = "aeiouAEIOU";
        int vowelCount = 0;
        int consCount = 0;
        int i;
        int length = str.length();
        for (i = 0; i < length; i++) {
            char currentChar = str.charAt(i);
            if (vowels.indexOf(currentChar) < 0 && Character.isLetter(currentChar))
                consCount++;
//            if (vowels.indexOf(currentChar) >= 0)
//                vowelCount++;
//            else if (Character.isLetter(currentChar))
//                consCount++;
        }
        return String.valueOf(consCount);
    }
}
