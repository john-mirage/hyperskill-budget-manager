package budget;

public class ActionExecutor {
    private final ExecutingMethod executingMethod;

    public ActionExecutor(ExecutingMethod executingMethod) {
        this.executingMethod = executingMethod;
    }

    public void execute(Account account) {
        this.executingMethod.execute(account);
    }
}
