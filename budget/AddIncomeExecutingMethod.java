package budget;

public class AddIncomeExecutingMethod implements ExecutingMethod {
    @Override
    public void execute(Account account) {
        double income = UserInterface.askForIncome();
        account.setBalance(account.getBalance() + income);
        System.out.println("Income was added!");
    }
}
