package christmas.domain;

public class SaleEvent {

    private final boolean isChristmasSale;
    private final boolean isWeekdaySale;
    private final boolean isHolidaySale;
    private final boolean isSpecialSale;

    public SaleEvent(int day) {
        this.isChristmasSale = isChristmasSale(day);
        this.isHolidaySale = isHoliday(day);
        this.isWeekdaySale = isWeekday(day);
        this.isSpecialSale = isSpecialSale(day);
    }

    public boolean isChristmasSale(int day) {
        return day <= 25;
    }

    public boolean isHoliday(int day) {
        return (day - 2) % 7 == 0 || (day - 3) % 7 == 0;
    }

    public boolean isWeekday(int day) {
        return !((day - 2) % 7 == 0 || (day - 3) % 7 == 0);
    }

    public boolean isSpecialSale(int day) {
        return (day - 3) % 7 == 0;
    }

    public int christmasSale(int day) {
        return 1000 + (100 * day);
    }
}
