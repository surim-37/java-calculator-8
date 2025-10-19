package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringAdd {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\\n(.*)");

    private StringAdd() {
    }

    public static int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] tokens = split(input);
        return sum(tokens);
    }

    private static String[] split(String input) {
        Matcher matcher = CUSTOM_PATTERN.matcher(input);
        if (matcher.matches()) {
            String customDelimiter = matcher.group(1);
            String numbers = matcher.group(2);
            return numbers.split(customDelimiter);
        }
        return input.split(DEFAULT_DELIMITER);
    }

    private static int sum(String[] tokens) {
        return Stream.of(tokens)
                .map(Number::from)
                .mapToInt(Number::toInt)
                .sum();
    }
}

