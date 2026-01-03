package christmas;

import christmas.config.AppConfig;
import christmas.controller.ChristmasController;

public class Application {
    public static void main(String[] args) {
        AppConfig config = new AppConfig();
        ChristmasController controller = config.christmasController();
        controller.run();
    }
}
