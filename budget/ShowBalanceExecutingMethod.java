package budget;

public class ShowBalanceExecutingMethod implements ExecutingMethod{
    @Override
    public void execute(Account account) {
        System.out.printf("Balance: $%.2f\n", account.getBalance());
    }
}
