package budget;

import java.util.Collections;
import java.util.List;

public class CertainTypeSortingMethod implements SortingMethod {

    private void sortByCertainType(Account account, Category category) {
        System.out.printf("%s:", category.getName());
        if (account.getPurchases().containsKey(category)) {
            List<Purchase> purchaseList = account.getPurchases().get(category);
            Collections.sort(purchaseList);
            double sum = 0;
            for (Purchase purchase : purchaseList) {
                sum += purchase.getPrice();
                System.out.printf("%s $%.2f\n", purchase.getName(), purchase.getPrice());
            }
            System.out.printf("Total sum: $%.2f\n", sum);
        } else {
            System.out.println("The category " + category.getName() + " does not exist!");
        }
    }

    @Override
    public void execute(Account account) {
        String sortingType = UserInterface.askForSortingMethodCategory();
        switch (sortingType) {
            case "1": this.sortByCertainType(account, Category.FOOD); break;
            case "2": this.sortByCertainType(account, Category.CLOTHES); break;
            case "3": this.sortByCertainType(account, Category.ENTERTAINMENT); break;
            case "4": this.sortByCertainType(account, Category.OTHER); break;
        }
    }
}
