package christmas.controller;

import christmas.util.InputValidator;
import christmas.view.InputView;
import christmas.view.OutputView;

public class InputController {

    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidator validator;

    public InputController(InputView inputView, OutputView outputView, InputValidator validator) {
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

    public String getMenuAndCount() {
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

    private String readMenuAndCount() {
        String value = inputView.readMenuAndCount();
        validator.validateMenuAndCount(value);
        return value;
    }

}
