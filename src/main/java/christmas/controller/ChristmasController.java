package christmas.controller;

import christmas.domain.Menu;
import christmas.domain.Menus;
import christmas.service.ChristmasService;
import christmas.view.OutputView;
import java.util.List;
import java.util.Map;

public class ChristmasController {

    private final InputController inputController;
    private final OutputView outputView;
    private final ChristmasService christmasService;

    public ChristmasController(InputController inputController, OutputView outputView, ChristmasService christmasService) {
        this.inputController = inputController;
        this.outputView = outputView;
        this.christmasService = christmasService;
    }

    public void run() {
        int visitDay = inputController.getVisitDay();
        List<String> menuAndCounts = inputController.getMenuAndCount();
        Menus menus = christmasService.createReservationMenu(menuAndCounts);
        printOrderedMenu(menus);
    }

    private void printOrderedMenu(Menus menus) {
        for (Map.Entry<Menu, Integer> entry : menus.getMenuAndCounts().entrySet()) {
            outputView.printOrderedMenu(entry);
        }
    }

}
