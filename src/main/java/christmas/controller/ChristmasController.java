package christmas.controller;

import christmas.domain.GiftEvent;
import christmas.domain.Menu;
import christmas.domain.Menus;
import christmas.domain.SaleEvent;
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

        int totalPrice = christmasService.calculateMenuPrice(menus);
        printBeforeTotalPrice(totalPrice);

        GiftEvent giftEvent = new GiftEvent(totalPrice);
        printPresentEvent(giftEvent);

        SaleEvent saleEvent = new SaleEvent(visitDay);
        printBenefits(saleEvent, giftEvent);
    }

    private void printOrderedMenu(Menus menus) {
        outputView.printOrderedMenuPrefix();
        for (Map.Entry<Menu, Integer> entry : menus.getMenuAndCounts().entrySet()) {
            outputView.printOrderedMenu(entry);
        }
    }

    private void printBeforeTotalPrice(int totalPrice) {
        outputView.printBeforeSaleTotalPrice(totalPrice);
    }

    private void printPresentEvent(GiftEvent giftEvent) {
        outputView.printPresentEvent(giftEvent.isPresentEvent());
    }

    private void printBenefits(SaleEvent saleEvent, GiftEvent giftEvent) {
        outputView.printBenefits();
        if (saleEvent.isChristmasSale()) {
            outputView.printChristmasSale();
        }
        if (saleEvent.isHolidaySale()) {
            outputView.printHolidaySale();
        }
        if (saleEvent.isWeekdaySale()) {
            outputView.printWeekdaySale();
        }
        if (saleEvent.isSpecialSale()) {
            outputView.printSpecialSale();
        }
        if (giftEvent.isPresentEvent()) {
            outputView.printPresentEventBenefit(giftEvent.isPresentEvent());
        }
    }

}
