package budget;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SaveExecutingMethod implements ExecutingMethod {
    @Override
    public void execute(Account account) {
        try {
            account.getFile().createNewFile();
            try (FileWriter writer = new FileWriter(account.getFile())) {
                List<Purchase> purchases = account.getAllPurchases();
                writer.write(account.getBalance() + "\n");
                for (Purchase purchase : purchases) {
                    writer.write("%s|%s|%s\n".formatted(purchase.getName(), String.valueOf(purchase.getPrice()), purchase.getCategory().name()));
                }
                System.out.println("Purchases were saved!");
            } catch (IOException e) {
                System.out.printf("An exception occurred %s", e.getMessage());
            }
        } catch (IOException e) {
            System.out.println("Cannot create the file: " + account.getFile().getPath());
        }
    }
}
