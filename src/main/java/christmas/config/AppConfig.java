package christmas.config;

import christmas.controller.ChristmasController;
import christmas.controller.InputController;
import christmas.util.InputValidator;
import christmas.view.InputView;
import christmas.view.OutputView;

public class AppConfig {

    public InputView inputView() {
        return new InputView();
    };

    public OutputView outputView() {
        return new OutputView();
    }

    public InputValidator validator() {
        return new InputValidator();
    }

    public InputController inputController() {
        return new InputController(
                inputView(),
                outputView(),
                validator()
        );
    }

    public ChristmasController christmasController() {
        return new ChristmasController(
                inputController(),
                outputView()
        );
    }
}
