package christmas.view;

import christmas.domain.Menu;
import java.util.Map;

public class OutputView {

    public void printErrorMessage(IllegalArgumentException e) {
        System.out.println("[ERROR] " + e.getMessage());
    }

    public void printOrderedMenu(Map.Entry<Menu, Integer> menu) {
        System.out.printf(menu.getKey().getMenu() + " %d개%n", menu.getValue());
    }
}
