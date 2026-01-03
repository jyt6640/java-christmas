package christmas.view;

public class OutputView {

    public void printErrorMessage(IllegalArgumentException e) {
        System.out.println("[ERROR] " + e.getMessage());
    }
}
