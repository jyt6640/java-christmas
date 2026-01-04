package christmas.controller;

import christmas.domain.GiftEvent;
import christmas.domain.Menu;
import christmas.domain.Menus;
import christmas.domain.SaleEvent;
import christmas.domain.SalePrice;
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
        int christmasSalePrice = christmasService.calculateChristmasSale(saleEvent, visitDay);
        int holidaySalePrice = christmasService.calculateHolidaySale(menus);
        int weekdaySalePrice = christmasService.calculateWeekdaySale(menus);
        int specialSalePrice = christmasService.calculateSpecialSale(saleEvent, visitDay);
        SalePrice salePrice = new SalePrice(christmasSalePrice, holidaySalePrice, weekdaySalePrice, specialSalePrice);
        printBenefits(saleEvent, visitDay, salePrice);
        printPresentEventBenefits(giftEvent);

        int totalBenefitPrice = christmasService.totalSalePrice(salePrice);
        outputView.printTotalBenefitPrice(totalBenefitPrice);

        int totalSalePrice = totalPrice - totalBenefitPrice;
        outputView.printTotalSalePrice(totalSalePrice);

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

    private void printBenefits(SaleEvent saleEvent, int visitDay, SalePrice salePrice) {
        outputView.printBenefits();
        if (saleEvent.isChristmasSale(visitDay)) {
            outputView.printChristmasSale(salePrice.getChristmasSalePrice());
        }
        if (saleEvent.isHoliday(visitDay)) {
            outputView.printHolidaySale(salePrice.getHolidaySalePrice());
        }
        if (!saleEvent.isHoliday(visitDay)) {
            outputView.printWeekdaySale(salePrice.getWeekdaySalePrice());
        }
        if (saleEvent.isSpecialSale(visitDay)) {
            outputView.printSpecialSale(salePrice.getSpecialSalePrice());
        }
    }

    private void printPresentEventBenefits(GiftEvent giftEvent) {
        if (giftEvent.isPresentEvent()) {
            outputView.printPresentEventBenefit(giftEvent.isPresentEvent());
        }
    }

}
