package christmas.controller;

import christmas.view.InputView;
import christmas.view.OutputView;

public class InputController {

    private final InputView inputView;
    private final OutputView outputView;

    public InputController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public String getVisitDay() {
        while (true) {
            try {
                return readVisitDay();
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception);
            }
        }
    }

    public String getMenuAndCount() {
        while (true) {
            try {
                return readMenuAndCount();
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception);
            }
        }
    }

    private String readVisitDay() {
        String value = inputView.readVisitDay();
        return value;
    }

    private String readMenuAndCount() {
        String value = inputView.readMenuAndCount();
        return value;
    }

}
