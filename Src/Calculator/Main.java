package Calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String[] expression = in.nextLine().split(" ");
        in.close();

        checkInputExpression(expression);

        String firstOperand = expression[0];
        String operator = expression[1];
        String secondOperand = expression[2];


        Checking checking = new Checking(firstOperand, operator, secondOperand);

        checking.checkNumberForInteger();

        ArabicNumerals arabicNumerals = new ArabicNumerals();

        if(checking.numberSystemCheck().equals("roman")) {

            int firstNumber = NumberSystemTranslation.translationRomanNumberInArabicNumber(firstOperand);
            int secondNumber = NumberSystemTranslation.translationRomanNumberInArabicNumber(secondOperand);

            checking.checkSizeNumber(firstNumber);
            checking.checkSizeNumber(secondNumber);

            arabicNumerals.setFirst(firstNumber);
            arabicNumerals.setSecond(secondNumber);

            int resultInArabicNumerals = computationByOperationArabicNumerals(arabicNumerals, operator);
            checking.checkOutputRomanNumber(resultInArabicNumerals);
            String result = NumberSystemTranslation.translationArabicNumberInRomanNumber(resultInArabicNumerals);

            System.out.println(result);
        }

        if(checking.numberSystemCheck().equals("arabic")) {

            int first = Integer.parseInt(firstOperand);
            int second = Integer.parseInt(secondOperand);

            checking.checkValidityOperands(first, second);

            arabicNumerals.setFirst(first);
            arabicNumerals.setSecond(second);

            int result = computationByOperationArabicNumerals(arabicNumerals, operator);

            System.out.println(result);
        }



    }

    public static int computationByOperationArabicNumerals(ArabicNumerals arabicNumerals, String operator ) {
        if(operator.equals("+")) {
            arabicNumerals.addition();
        }

        if(operator.equals("-")) {
            arabicNumerals.subtraction();
        }

        if(operator.equals("*")) {
            arabicNumerals.multiplication();
        }

        if(operator.equals("/")) {
            arabicNumerals.division();
        }

        return arabicNumerals.getResult();
    }

    public static void checkInputExpression(String[] expression) throws Exception {
        if(expression.length > 3) {
            throw new Exception("Должны быть два числа и оператор");
        }

        if(expression.length < 2) {
            throw new Exception("Это не математическое выражение");
        }
    }

}
