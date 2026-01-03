package christmas.service;

import christmas.domain.GiftEvent;
import christmas.domain.Menu;
import christmas.domain.Menus;
import java.util.List;
import java.util.Map;

public class ChristmasService {

    public Menus createReservationMenu(List<String> menuAndCounts) {
        return new Menus(menuAndCounts);
    }

    public int calculateMenuPrice(Menus menus) {
        int totalPrice = 0;
        GiftEvent giftEvent = new GiftEvent(totalPrice);

        for (Map.Entry<Menu, Integer> entry : menus.getMenuAndCounts().entrySet()) {
            totalPrice += (entry.getKey().getPrice()) * entry.getValue();
        }

        return totalPrice;
    }
}
