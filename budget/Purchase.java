package budget;

public class Purchase implements Comparable<Purchase> {
    private final String name;
    private final double price;
    private final Category category;

    public Purchase(String name, double price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public Category getCategory() {
        return this.category;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;
        Purchase purchase = (Purchase) that;
        return this.price == purchase.getPrice();
    }

    @Override
    public int compareTo(Purchase that) {
        return Double.compare(that.getPrice(), this.price);
    }
}
