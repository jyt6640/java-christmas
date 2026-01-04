package christmas.domain;

import java.util.ArrayList;
import java.util.List;

public class SalePrice {

    private List<Integer> totalSalePrice = new ArrayList<>();
    private int christmasSalePrice;
    private int holidaySalePrice;
    private int weekdaySalePrice;
    private int specialSalePrice;

    public SalePrice(int christmasSalePrice, int holidaySalePrice, int weekdaySalePrice, int specialSalePrice) {
        this.christmasSalePrice = christmasSalePrice;
        this.holidaySalePrice = holidaySalePrice;
        this.weekdaySalePrice = weekdaySalePrice;
        this.specialSalePrice = specialSalePrice;

        totalSalePrice.add(christmasSalePrice);
        totalSalePrice.add(holidaySalePrice);
        totalSalePrice.add(weekdaySalePrice);
        totalSalePrice.add(specialSalePrice);
    }

    public List<Integer> getTotalSalePrice() {
        return totalSalePrice;
    }

    public int getChristmasSalePrice() {
        return christmasSalePrice;
    }

    public int getHolidaySalePrice() {
        return holidaySalePrice;
    }

    public int getWeekdaySalePrice() {
        return weekdaySalePrice;
    }

    public int getSpecialSalePrice() {
        return specialSalePrice;
    }
}
