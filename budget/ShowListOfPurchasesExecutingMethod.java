package budget;

import java.util.List;

public class ShowListOfPurchasesExecutingMethod implements ExecutingMethod {

    private void showListOfPurchases(Account account) {
        System.out.println("All:");
        if (account.hasPurchases()) {
            double sum = 0.0;
            for (List<Purchase> purchases : account.getPurchases().values()) {
                if (!purchases.isEmpty()) {
                    for (Purchase purchase : purchases) {
                        sum += purchase.getPrice();
                        System.out.printf("%s $%.2f\n", purchase.getName(), purchase.getPrice());
                    }
                }
            }
            System.out.printf("Total sum: $%.2f\n", sum);
        } else {
            System.out.println("The purchase list is empty!");
        }
    }

    private void showListOfPurchases(Account account, Category category) {
        System.out.println(category.getName() + ":");
        if (account.getPurchases().containsKey(category)) {
            List<Purchase> categoryPurchases = account.getPurchases().get(category);
            if (!categoryPurchases.isEmpty()) {
                double sum = 0.0;
                for (Purchase purchase : categoryPurchases) {
                    sum += purchase.getPrice();
                    System.out.printf("%s $%.2f\n", purchase.getName(), purchase.getPrice());
                }
                System.out.printf("Total sum: $%.2f\n", sum);
            } else {
                System.out.println("Purchase list is empty!");
            }
        } else {
            System.out.println("The category " + category.getName() + " does not exist!");
        }
    }

    @Override
    public void execute(Account account) {
        if (account.hasPurchases()) {
            while (true) {
                String category = UserInterface.askForTypeOfPurchaseWhenListing();
                if (!category.equals("6")) {
                    switch (category) {
                        case "1": this.showListOfPurchases(account, Category.FOOD); break;
                        case "2": this.showListOfPurchases(account, Category.CLOTHES); break;
                        case "3": this.showListOfPurchases(account, Category.ENTERTAINMENT); break;
                        case "4": this.showListOfPurchases(account, Category.OTHER); break;
                        case "5": this.showListOfPurchases(account); break;
                    }
                    System.out.println();
                } else {
                    break;
                }
            }
        } else {
            System.out.println("The purchase list is empty!");
        }
    }
}
