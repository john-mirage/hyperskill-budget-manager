package budget;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class LoadExecutingMethod implements ExecutingMethod {
    
    private void addPurchase(Account account, Purchase purchase) {
        if (account.getPurchases().containsKey(purchase.getCategory())) {
            List<Purchase> categoryPurchases = account.getPurchases().get(purchase.getCategory());
            categoryPurchases.add(purchase);
        } else {
            throw new IllegalArgumentException("Category " + purchase.getCategory().getName() + " does not exist");
        }
    }
    
    @Override
    public void execute(Account account) {
        try (Scanner scanner = new Scanner(account.getFile())) {
            if (scanner.hasNext()) {
                double balance = Double.parseDouble(scanner.nextLine());
                account.setBalance(account.getBalance() + balance);
                while (scanner.hasNext()) {
                    String[] line = scanner.nextLine().split("\\|");
                    String name = line[0];
                    double price = Double.parseDouble(line[1]);
                    String category = line[2];
                    this.addPurchase(account, new Purchase(name, price, Category.valueOf(category)));
                }
                System.out.println("Purchases were loaded!");
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + account.getFile().getAbsolutePath());
        }
    }
}
