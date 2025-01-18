package budget;

public class ByTypeSortingMethod implements SortingMethod {
    @Override
    public void execute(Account account) {
        System.out.println("Types:");
        double totalSum = 0;
        for (Category category : account.getPurchases().keySet()) {
            double sum = 0;
            for (Purchase purchase : account.getPurchases().get(category)) {
                sum += purchase.getPrice();
                totalSum += purchase.getPrice();
            }
            System.out.printf("%s - $%.2f\n", category.getName(), sum);
        }
        System.out.printf("Total sum: $%.2f\n", totalSum);
    }
}
