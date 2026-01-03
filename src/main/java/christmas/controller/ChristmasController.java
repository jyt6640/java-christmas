package christmas.controller;

import christmas.view.OutputView;

public class ChristmasController {

    private final InputController inputController;
    private final OutputView outputView;

    public ChristmasController(InputController inputController, OutputView outputView) {
        this.inputController = inputController;
        this.outputView = outputView;
    }

    public void run() {

    }

}
