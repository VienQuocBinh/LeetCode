package practice.fsoft;

/*
 Next character and if there is vowel then upper case
 */
public class LetterChange {
    public static void main(String[] args) {
        System.out.println(letterChange("hello*3"));
        System.out.println(letterChange("fun times!"));
    }

    public static String letterChange(String str) {
        String vowels = "aeiouAEIOU";
        StringBuilder result = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char currentChar = str.charAt(i);
            if (Character.isLetter(currentChar)) {
                char currentCharChanged = (char) (currentChar + 1);
                if (vowels.indexOf(currentCharChanged) >= 0)
                    currentChar = Character.toUpperCase(currentCharChanged);
                else currentChar = currentCharChanged;
            }
            result.append(currentChar);
        }
        return result.toString();
    }
}
