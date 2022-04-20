package Calculator;

public class NumberSystemTranslation {

    public static int translationRomanNumberInArabicNumber(String romanNumber) {
        int result = 0;

        String roman = romanNumber.toUpperCase();

        for (int i = 0; i < roman.length() - 1; i++) {
            if (translationSingleCharacter(roman.charAt(i)) < translationSingleCharacter(roman.charAt(i + 1))) {
                result -= translationSingleCharacter(roman.charAt(i));
            } else {
                result += translationSingleCharacter(roman.charAt(i));
            }
        }
        result += translationSingleCharacter(roman.charAt(roman.length() - 1));

        return result;
    }

    public static String translationArabicNumberInRomanNumber(int arabicNumber) {

        int[] romanValueList = new int[]{100, 50,10, 9, 5, 4, 1};
        String[] romanCharList = new String[]{"C", "L", "X", "IX", "V", "IV", "I"};
        String romanNumber = "";

        for (int i = 0; i < romanValueList.length; i++) {
            while (arabicNumber >= romanValueList[i]){
                arabicNumber -= romanValueList[i];
                romanNumber += romanCharList[i];
            }
        }
        return romanNumber;

    }

    private static int translationSingleCharacter(char letter) {
        switch (letter) {
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
            default:
                return 0;
        }
    }

}