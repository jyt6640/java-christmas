package christmas.config;

import christmas.controller.ChristmasController;
import christmas.controller.InputController;
import christmas.service.ChristmasService;
import christmas.util.Validator;
import christmas.view.InputView;
import christmas.view.OutputView;

public class AppConfig {

    public InputView inputView() {
        return new InputView();
    };

    public OutputView outputView() {
        return new OutputView();
    }

    public Validator validator() {
        return new Validator();
    }

    public InputController inputController() {
        return new InputController(
                inputView(),
                outputView(),
                validator()
        );
    }

    public ChristmasService christmasService() {
        return new ChristmasService();
    }

    public ChristmasController christmasController() {
        return new ChristmasController(
                inputController(),
                outputView(),
                christmasService()
        );
    }
}
