package calculator;

public class Number {

    private final int value;

    private Number(int value) {
        validate(value);
        this.value = value;
    }

    public static Number from(String input) {
        if (input == null || input.isEmpty()) {
            return new Number(0);
        }
        try {
            int parsed = Integer.parseInt(input);
            return new Number(parsed);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: " + input);
        }
    }

    private void validate(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + value);
        }
    }

    public int toInt() {
        return value;
    }
}


