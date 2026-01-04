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
    
    public void printBenefits() {
        System.out.println();
        System.out.println("<혜택 내역>");
    }
    
    public void printChristmasSale(int salePrice) {
        System.out.println();
        System.out.printf("크리스마스 디 데이 할인: -%s원", salePrice);
    }
    
    public void printHolidaySale(int salePrice) {
        System.out.println();
        System.out.printf("주말 할인: -%s원", salePrice);
    }
    
    public void printWeekdaySale(int salePrice) {
        System.out.println();
        System.out.printf("평일 할인: -%s원", salePrice);
    }

    public void printSpecialSale(int salePrice) {
        System.out.println();
        System.out.printf("특별 할인: -%s원", salePrice);
    }
    
    public void printPresentEventBenefit(boolean isPresentEvent) {
        if (isPresentEvent) {
            System.out.println("증정 이벤트: -25,000원");
        }
    }

    public void printTotalBenefitPrice(int totalBenefitPrice) {
        System.out.println();
        System.out.println("총혜택 금액");
        System.out.printf("-%s원", totalBenefitPrice);
        System.out.println();
    }

    public void printTotalSalePrice(int totalSalePrice) {
        System.out.println();
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.printf("%s원", totalSalePrice);
        System.out.println();
    }
}
