package budget;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Account {
    private final Map<Category, List<Purchase>> purchases;
    private double balance;
    private File file;

    public Account() {
        this.purchases = new HashMap<>();
        this.balance = 0;
        this.file = new File("./purchases.txt");
        for (Category category : Category.values()) {
            this.purchases.put(category, new ArrayList<>());
        }
    }

    public Map<Category, List<Purchase>> getPurchases() {
        return this.purchases;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public File getFile() {
        return this.file;
    }
    
    public boolean hasPurchases() {
        boolean empty = true;
        for (List<Purchase> purchaseList : this.purchases.values()) {
            if (!purchaseList.isEmpty()) {
                empty = false;
                break;
            }
        }
        return !empty;
    }

    public List<Purchase> getAllPurchases() {
        List<Purchase> allPurchases = new ArrayList<>();
        for (List<Purchase> purchaseList : this.purchases.values()) {
            allPurchases.addAll(purchaseList);
        }
        return allPurchases;
    }
}
