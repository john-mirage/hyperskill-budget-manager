package budget;

import java.util.Scanner;

public class UserInterface {
    private static final Scanner scanner = new Scanner(System.in);

    public static String askForAction() {
        while (true) {
            System.out.println("""
                Choose your action:
                1) Add income
                2) Add purchase
                3) Show list of purchases
                4) Balance
                5) Save
                6) Load
                7) Analyze (Sort)
                0) Exit
                """);
            String input = scanner.nextLine().trim();
            if (input.matches("[01234567]")) {
                return input;
            } else {
                System.out.println("Invalid action");
            }
        }
    }

    public static String askForTypeOfPurchaseWhenAdding() {
        while (true) {
            System.out.println("""
                Choose the type of purchase
                1) Food
                2) Clothes
                3) Entertainment
                4) Other
                5) Back
                """);
            String input = scanner.nextLine().trim();
            if (input.matches("[012345]")) {
                return input;
            } else {
                System.out.println("Invalid type of purchase");
            }
        }
    }

    public static String askForTypeOfPurchaseWhenListing() {
        while (true) {
            System.out.println("""
                Choose the type of purchases
                1) Food
                2) Clothes
                3) Entertainment
                4) Other
                5) All
                6) Back
                """);
            String input = scanner.nextLine().trim();
            if (input.matches("[0123456]")) {
                return input;
            } else {
                System.out.println("Invalid type of purchase");
            }
        }
    }

    public static Double askForIncome() {
        while (true) {
            System.out.println("Enter income:");
            String input = scanner.nextLine().trim();
            try {
                double income = Double.parseDouble(input);
                if (income > 0) {
                    return income;
                } else {
                    System.out.println("Invalid income");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid income");
            }
        }
    }

    public static String askForPurchaseName() {
        while (true) {
            System.out.println("Enter purchase name:");
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            } else {
                System.out.println("Invalid purchase name");
            }
        }
    }

    public static Double askForPurchasePrice() {
        while (true) {
            System.out.println("Enter its price:");
            String input = scanner.nextLine().trim();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid price");
            }
        }
    }

    public static String askForSortingMethod() {
        while (true) {
            System.out.println("""
                How do you want to sort?
                1) Sort all purchases
                2) Sort by type
                3) Sort certain type
                4) Back
                """);
            String input = scanner.nextLine().trim();
            if (input.matches("[01234]")) {
                return input;
            } else {
                System.out.println("Invalid sorting method");
            }
        }
    }

    public static String askForSortingMethodCategory() {
        while (true) {
            System.out.println("""
                Choose the type of purchase
                1) Food
                2) Clothes
                3) Entertainment
                4) Other
                """);
            String input = scanner.nextLine().trim();
            if (input.matches("[01234]")) {
                return input;
            } else {
                System.out.println("Invalid sorting method category");
            }
        }
    }
}
