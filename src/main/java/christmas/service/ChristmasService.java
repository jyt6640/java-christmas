package christmas.service;

import christmas.domain.Menu;
import christmas.domain.Menus;
import christmas.domain.SaleEvent;
import christmas.domain.SalePrice;
import java.util.List;
import java.util.Map;

public class ChristmasService {

    public Menus createReservationMenu(List<String> menuAndCounts) {
        return new Menus(menuAndCounts);
    }

    public int calculateMenuPrice(Menus menus) {
        int totalPrice = 0;

        for (Map.Entry<Menu, Integer> entry : menus.getMenuAndCounts().entrySet()) {
            totalPrice += (entry.getKey().getPrice()) * entry.getValue();
        }

        return totalPrice;
    }

    public int calculateChristmasSale(SaleEvent saleEvent, int day) {
        if (saleEvent.isChristmasSale(day)) {
            return saleEvent.christmasSale(day);
        }
        return 0;
    }

    public int calculateHolidaySale(Menus menus) {
        int totalSalePrice = 0;
        for (Map.Entry<Menu, Integer> entry : menus.getMenuAndCounts().entrySet()) {
            if (entry.getKey().getType() == 2) {
                totalSalePrice += ((entry.getKey().getPrice()) - 2023) * entry.getValue();
            }
        }
        return totalSalePrice;
    }

    public int calculateWeekdaySale(Menus menus) {
        int totalSalePrice = 0;
        for (Map.Entry<Menu, Integer> entry : menus.getMenuAndCounts().entrySet()) {
            if (entry.getKey().getType() == 1) {
                totalSalePrice += ((entry.getKey().getPrice()) - 2023) * entry.getValue();
            }
        }
        return totalSalePrice;
    }

    public int calculateSpecialSale(SaleEvent saleEvent, int day) {
        if (saleEvent.isSpecialSale(day)) {
            return 1000;
        }
        return 0;
    }

    public int totalSalePrice(SalePrice salePrice) {
        int totalSalePrice = 0;
        for (int p : salePrice.getTotalSalePrice()) {
            totalSalePrice += p;
        }
        return totalSalePrice;
    }
}
