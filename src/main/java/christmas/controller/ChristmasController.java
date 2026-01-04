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
        SalePrice salePrice = calculateSalePrice(menus, visitDay, saleEvent);

        outputView.printBenefits();
        if (isEvent(menus, saleEvent, totalPrice)) {
            printBenefits(saleEvent, visitDay, salePrice);
        }
        if (!isEvent(menus, saleEvent, totalPrice)) {
            outputView.printNothing();
        }

        printPresentEventBenefits(giftEvent);

        int totalBenefitPrice = christmasService.totalSalePrice(salePrice);
        outputView.printTotalBenefitPrice(totalBenefitPrice);

        int totalSalePrice = totalPrice - totalBenefitPrice;
        outputView.printTotalSalePrice(totalSalePrice);

        outputView.printBadge(giftEvent.getBadge().getName());

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
        boolean hasBenefit = false;
        if (saleEvent.isChristmasSale(visitDay) && salePrice.getChristmasSalePrice() > 0) {
            outputView.printChristmasSale(salePrice.getChristmasSalePrice());
            hasBenefit = true;
        }
        if (saleEvent.isHoliday(visitDay) && salePrice.getHolidaySalePrice() > 0) {
            outputView.printHolidaySale(salePrice.getHolidaySalePrice());
            hasBenefit = true;
        }
        if (saleEvent.isWeekday(visitDay) && salePrice.getWeekdaySalePrice() > 0) {
            outputView.printWeekdaySale(salePrice.getWeekdaySalePrice());
            hasBenefit = true;
        }
        if (saleEvent.isSpecialSale(visitDay) && salePrice.getSpecialSalePrice() > 0) {
            outputView.printSpecialSale(salePrice.getSpecialSalePrice());
            hasBenefit = true;
        }
        if (!hasBenefit) {
            outputView.printNothing();
        }
    }

    private SalePrice calculateSalePrice(Menus menus, int visitDay, SaleEvent saleEvent) {
        int christmasSalePrice = christmasService.calculateChristmasSale(saleEvent, visitDay);
        int holidaySalePrice = christmasService.calculateHolidaySale(menus);
        int weekdaySalePrice = christmasService.calculateWeekdaySale(menus);
        int specialSalePrice = christmasService.calculateSpecialSale(saleEvent, visitDay);
        return new SalePrice(christmasSalePrice, holidaySalePrice, weekdaySalePrice, specialSalePrice);
    }

    private void printPresentEventBenefits(GiftEvent giftEvent) {
        if (giftEvent.isPresentEvent()) {
            outputView.printPresentEventBenefit(giftEvent.isPresentEvent());
        }
    }

    private boolean isEvent(Menus menus, SaleEvent saleEvent, int totalPrice) {
        if (totalPrice < 10000) {
            return false;
        }
        if (menus.hasOnlyDrink()) {
            return false;
        }
        return true;
    }

}
