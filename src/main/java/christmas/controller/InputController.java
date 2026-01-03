package christmas.controller;

import christmas.util.Validator;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;

public class InputController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Validator validator;

    public InputController(InputView inputView, OutputView outputView, Validator validator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.validator = validator;
    }

    public int getVisitDay() {
        while (true) {
            try {
                return readVisitDay();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    public List<String> getMenuAndCount() {
        while (true) {
            try {
                return readMenuAndCount();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private int readVisitDay() {
        String value = inputView.readVisitDay();
        validator.validateVisitDay(value);
        return Integer.parseInt(value);
    }

    private List<String> readMenuAndCount() {
        String value = inputView.readMenuAndCount();
        List<String> menus = List.of(value.split(","));
        validator.validateMenuAndCount(menus);
        return menus;
    }

}
