package christmas.util;

public class InputValidator {

    public static final String NUMERIC_PATTERN = "^[0-9]+$";

    public void validateVisitDay(String visitDay) {
        emptyDay(visitDay);
        onlyNumber(visitDay);
    }

    public void validateMenuAndCount(String menuAndCount) {
        emptyMeny(menuAndCount);
    }

    private void emptyMeny(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private void emptyDay(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    private void onlyNumber(String input) {
        if (!input.matches(NUMERIC_PATTERN)) {
            throw new IllegalArgumentException("유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }
}
