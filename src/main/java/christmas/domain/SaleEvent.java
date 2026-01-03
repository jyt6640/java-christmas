package christmas.domain;

public class SaleEvent {

    private final boolean isChristmasSale;
    private final boolean isWeekendSale;
    private final boolean isSpecialSale;

    public SaleEvent(int day) {
        this.isChristmasSale = isChristmasSale(day);
        this.isWeekendSale = isWeekendSale(day);
        this.isSpecialSale = isSpecialSale(day);
    }

    private boolean isChristmasSale(int day) {
        if (day <= 25) {
            return true;
        }
        return false;
    }

    private boolean isWeekendSale(int day) {
        if ((day - 2) % 7 == 0 || (day - 3) % 7 == 0) {
            return true;
        }
        return false;
    }

    private boolean isSpecialSale(int day) {
        if ((day - 3) % 7 == 0) {
            return true;
        }
        return false;
    }

    public boolean isChristmasSale() {
        return isChristmasSale;
    }

    public boolean isWeekendSale() {
        return isWeekendSale;
    }

    public boolean isSpecialSale() {
        return isSpecialSale;
    }
}
