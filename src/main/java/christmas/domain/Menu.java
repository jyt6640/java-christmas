package christmas.domain;

public enum Menu {

    SOUP("양송이수프", 6000, 0),
    TAPAS("타파스", 5500, 0),
    SALAD("시저샐러드", 8000, 0),
    STEAK("티본스테이크", 55000, 1),
    BARBECUE("바비큐립", 54000, 1),
    SEAFOODPASTA("해산물파스타", 35000, 1),
    CHRISTMASPASTA("크리스마스파스타", 25000, 1),
    CAKE("초코케이크", 15000, 2),
    ICECREAM("아이스크림", 5000, 2),
    COKE("제로콜라", 3000, 3),
    WINE("레드와인", 60000, 3),
    CHAMPAGNE("샴페인", 25000, 3);

    private String menu;
    private int price;
    private int type;

    Menu(String menu, int price, int type) {
        this.menu = menu;
        this.price = price;
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public String getMenu() {
        return menu;
    }

    public int getPrice() {
        return price;
    }

    public static Menu fromString(String menu) {
        for (Menu m : Menu.values()) {
            if (m.menu.equalsIgnoreCase(menu)) {
                return m;
            }
        }
        throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

}
