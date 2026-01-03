package christmas.util;

import christmas.domain.Menu;
import java.util.List;

public class Validator {

    public static final String NUMERIC_PATTERN = "^[0-9]+$";

    public void validateVisitDay(String visitDay) {
        emptyDay(visitDay);
        onlyNumberDay(visitDay);
    }

    public void validateMenuAndCount(List<String> menuAndCount) {
        emptyMenu(menuAndCount);
        inputMenuCount(menuAndCount);
    }

    private void emptyMenu(List<String> input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private void emptyDay(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    private void onlyNumberDay(String input) {
        if (!input.matches(NUMERIC_PATTERN)) {
            throw new IllegalArgumentException("유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    private void inputMenuCount(List<String> input) {
        for (String menu : input) {
            String[] menuAndCount = menu.split("-");
            onlyNumberCount(menuAndCount[1]);
            hasMenu(menuAndCount[0]);
        }
    }

    private void onlyNumberCount(String input) {
        if (!input.matches(NUMERIC_PATTERN)) {
            throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private void hasMenu(String menu) {
        if (menu.equalsIgnoreCase(menu)) {
            throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
}
