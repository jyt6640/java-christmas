package christmas.domain;

public class SaleEvent {

    private final boolean isChristmasSale;
    private final boolean isWeekdaySale;
    private final boolean isHolidaySale;
    private final boolean isSpecialSale;

    public SaleEvent(int day) {
        this.isChristmasSale = isChristmasSale(day);
        this.isHolidaySale = isHoliday(day);
        this.isWeekdaySale = !isHoliday(day);
        this.isSpecialSale = isSpecialSale(day);
    }

    private boolean isChristmasSale(int day) {
        return day <= 25;
    }

    private boolean isHoliday(int day) {
        return (day - 2) % 7 == 0 || (day - 3) % 7 == 0;
    }

    private boolean isSpecialSale(int day) {
        return (day - 3) % 7 == 0;
    }

    public int christmasSale(int money, int day) {
        return money - (1000 + (100 * day));
    }

    public int daySale(int money) {
        return money - 2023;
    }

    public int specialSale(int money) {
        return money - 1000;
    }

    public boolean isChristmasSale() {
        return isChristmasSale;
    }

    public boolean isWeekdaySale() {
        return isWeekdaySale;
    }

    public boolean isHolidaySale() {
        return isHolidaySale;
    }

    public boolean isSpecialSale() {
        return isSpecialSale;
    }
}
