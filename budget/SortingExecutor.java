package budget;

public class SortingExecutor {
    private final SortingMethod sortingMethod;

    public SortingExecutor(SortingMethod sortingMethod) {
        this.sortingMethod = sortingMethod;
    }

    public void execute(Account account) {
        this.sortingMethod.execute(account);
    }
}
