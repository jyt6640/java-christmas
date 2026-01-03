package christmas.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menus {

    private Map<Menu, Integer> menuAndCounts;

    public Menus(List<String> menus) {
        this.menuAndCounts = new HashMap<>();
        for (String menu : menus) {
            String[] menuAndCount = menu.split("-");
            menuAndCounts.put(getMenu(menuAndCount), getCount(menuAndCount));
        }
    }

    private Menu getMenu(String[] menu) {
        return Menu.fromString(menu[0]);
    }

    private int getCount(String[] menu) {
        return Integer.parseInt(menu[1]);
    }

    public Map<Menu, Integer> getMenuAndCounts() {
        return menuAndCounts;
    }
}
