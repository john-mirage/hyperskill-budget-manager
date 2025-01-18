package budget;

public class BudgetManager {
    private final Account account;

    public BudgetManager() {
        this.account = new Account();
    }

    public void start() {
        while (true) {
            String action = UserInterface.askForAction();
            if (!action.equals("0")) {
                ActionExecutor actionExecutor = switch (action) {
                    case "1" -> new ActionExecutor(new AddIncomeExecutingMethod());
                    case "2" -> new ActionExecutor(new AddPurchaseExecutingMethod());
                    case "3" -> new ActionExecutor(new ShowListOfPurchasesExecutingMethod());
                    case "4" -> new ActionExecutor(new ShowBalanceExecutingMethod());
                    case "5" -> new ActionExecutor(new SaveExecutingMethod());
                    case "6" -> new ActionExecutor(new LoadExecutingMethod());
                    case "7" -> new ActionExecutor(new AnalyzeExecutingMethod());
                    default -> null;
                };
                if (actionExecutor != null) {
                    System.out.println();
                    actionExecutor.execute(this.account);
                    System.out.println();
                } else {
                    throw new RuntimeException("Invalid action");
                }
            } else {
                System.out.println("Bye!");
                break;
            }
        }
    }
}
