package Calculator;

public class ArabicNumerals {

    public int first;
    public int second;
    public int result;

    public void addition() {
        this.result = this.first + this.second;
    }

    public void subtraction() {
        this.result = this.first - this.second;
    }

    public void division() {
        this.result = Math.round(this.first / this.second);
    }

    public void multiplication() {
        this.result = this.first * this.second;
    }

    public int getResult() {
        return this.result;
    }

    public void setFirst(int number) {
        this.first = number;
    }

    public void setSecond(int number) {
        this.second = number;
    }

}