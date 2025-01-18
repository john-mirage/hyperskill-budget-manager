package budget;

import java.util.List;
import java.util.Map;

public class AddPurchaseExecutingMethod implements ExecutingMethod {

    public void addPurchase(Account account, Purchase purchase) {
        Map<Category, List<Purchase>> purchases = account.getPurchases();
        if (purchases.containsKey(purchase.getCategory())) {
            List<Purchase> categoryPurchases = purchases.get(purchase.getCategory());
            categoryPurchases.add(purchase);
            account.setBalance(account.getBalance() - purchase.getPrice());
            System.out.println("Purchase was added!");
        } else {
            throw new IllegalArgumentException("Category " + purchase.getCategory().getName() + " does not exist");
        }
    }

    @Override
    public void execute(Account account) {
        while (true) {
            String category = UserInterface.askForTypeOfPurchaseWhenAdding();
            if (!category.equals("5")) {
                String name = UserInterface.askForPurchaseName();
                double price = UserInterface.askForPurchasePrice();
                switch (category) {
                    case "1": this.addPurchase(account, new Purchase(name, price, Category.FOOD)); break;
                    case "2": this.addPurchase(account, new Purchase(name, price, Category.CLOTHES)); break;
                    case "3": this.addPurchase(account, new Purchase(name, price, Category.ENTERTAINMENT)); break;
                    case "4": this.addPurchase(account, new Purchase(name, price, Category.OTHER)); break;
                }
                System.out.println();
            } else {
                break;
            }
        }
    }
}
