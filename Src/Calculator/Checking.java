package Calculator;

public class Checking {

    private String first;
    private final String operator;
    private String second;
    private final int[] arabicNumerals = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    private final String[] romanNumerals = {"I", "V", "X"};

    Checking(String firstArgument, String operator, String secondArgument ) {
        this.first = firstArgument;
        this.operator = operator;
        this.second = secondArgument;
    }

    public void checkValidityOperands(int first, int second) throws Exception {
        checkSizeNumber(first);
        checkSizeNumber(second);
        checkValidateOperator();
    }

    public String numberSystemCheck() throws Exception {

        try {


            if(findElement(this.first) && findElement(this.second)) {
                return "roman";
            }

            if(findElement(Integer.parseInt(this.first)) && findElement(Integer.parseInt(this.second))) {
                return "arabic";
            }

        } catch (Exception e) {
            e.getMessage();
            throw new Exception("Невозможно использовать два типа чисел.");
        }

        return "";

    }

    private boolean findElement(String searchItem) {
        for (String numeral : this.romanNumerals) {
            if(searchItem.length() > 1) {
                for(int i = 0; i < searchItem.length(); i++) {
                    if(numeral.equals(String.valueOf(searchItem.charAt(i)))) {
                        return true;
                    }
                }
            } else {
                if(searchItem.equals(numeral)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean findElement(int searchItem) {
        for (int numeral : this.arabicNumerals) {
            String item = String.valueOf(searchItem);
            if(item.length() > 1) {
                for(int i = 0; i < item.length(); i++) {
                    if(numeral == Integer.parseInt(String.valueOf(item.charAt(i)))) {
                        return true;
                    }
                }
            } else {
                if(searchItem == numeral) {
                    return true;
                }
            }
        }

        return false;
    }


    public void checkSizeNumber(int number) throws Exception {
        if(number > 10 || number < 0) {
            throw new Exception("Число может быть нулем или не больше десяти");
        }
    }

    public void checkValidateOperator() throws Exception {
        if(
                !this.operator.equals("+") &&
                        !this.operator.equals("-") &&
                        !this.operator.equals("/") &&
                        !this.operator.equals("*"))
        {
            throw new Exception("Выполняется лишь деление, сложение, умножение, вычитание");
        }
    }

    public void checkOutputRomanNumber(int number) throws Exception {
        if(number < 1) {
            throw new Exception("Римская цифра не может быть меньше нуля");
        }
    }

    public void checkNumberForInteger() throws Exception {
        try {
            if(!findElement(this.first) && !findElement(this.second)) {
                int first = Integer.parseInt(this.first);
                int second = Integer.parseInt(this.second);
                this.first = String.valueOf(first);
                this.second = String.valueOf(second);

            }
        } catch (Exception e) {
            throw new Exception("Числа должны быть целыми");
        }
    }


}