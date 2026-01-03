package christmas.view;

import christmas.domain.Menu;
import java.util.Map;

public class OutputView {

    public void printErrorMessage(IllegalArgumentException e) {
        System.out.println("[ERROR] " + e.getMessage());
    }

    public void printOrderedMenuPrefix() {
        System.out.println("<주문 메뉴>");
    }

    public void printOrderedMenu(Map.Entry<Menu, Integer> menu) {
        System.out.printf(menu.getKey().getMenu() + " %d개%n", menu.getValue());
    }

    public void printBeforeSaleTotalPrice(int totalPrice) {
        System.out.println();
        System.out.println("<할인 전 총주문 금액>");
        System.out.printf("%s원", totalPrice);
        System.out.println();
    }

    public void printPresentEvent(boolean isPresentEvent) {
        System.out.println();
        System.out.println("<증정 메뉴>");
        if (isPresentEvent) {
            System.out.println("샴페인 1개");
        }
        if (!isPresentEvent) {
            System.out.println("없음");
        }
    }
}
