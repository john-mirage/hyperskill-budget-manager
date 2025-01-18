package budget;

import java.util.Collections;
import java.util.List;

public class AllSortingMethod implements SortingMethod {
    @Override
    public void execute(Account account) {
        if (account.hasPurchases()) {
            List<Purchase> purchases = account.getAllPurchases();
            Collections.sort(purchases);
            double sum = 0;
            for (Purchase purchase : purchases) {
                sum += purchase.getPrice();
                System.out.printf("%s $%.2f\n", purchase.getName(), purchase.getPrice());
            }
            System.out.printf("Total: $%.2f\n", sum);
        } else {
            System.out.println("The purchase list is empty!");
        }
    }
}
