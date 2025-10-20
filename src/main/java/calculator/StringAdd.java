package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringAdd {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");

    private StringAdd() {}

    public static int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        // ✅ "\n" 리터럴을 실제 개행으로 정규화
        String normalized = input.replace("\\n", "\n");
        String[] tokens = split(normalized);
        return sum(tokens);
    }

    private static String[] split(String input) {
        Matcher matcher = CUSTOM_PATTERN.matcher(input);
        if (matcher.matches()) {
            String customDelimiter = matcher.group(1);
            String numbers = matcher.group(2);
            // ✅ 특수문자 구분자 대응
            return numbers.split(Pattern.quote(customDelimiter));
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