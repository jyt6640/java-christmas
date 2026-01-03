package christmas.domain;

public class GiftEvent {

    private final boolean isPresentEvent;
    private final Badge badge;
    private final int money;

    public GiftEvent(int money) {
        this.isPresentEvent = isPresentEventDay(money);
        this.badge = giveBadge(money);
        this.money = money;
    }

    private boolean isPresentEventDay(int money) {
        if (money >= 120000) {
            return true;
        }
        return false;
    }

    private Badge giveBadge(int money) {
        if (money >= 5000) {
            return Badge.STAR;
        }
        if (money >= 10000) {
            return Badge.TREE;
        }
        if (money >= 20000) {
            return Badge.SANTA;
        }
        return Badge.NONE;
    }

    public boolean isPresentEvent() {
        return isPresentEvent;
    }

    public Badge getBadge() {
        return badge;
    }
}
