package budget;

public class AnalyzeExecutingMethod implements ExecutingMethod {
    @Override
    public void execute(Account account) {
        while (true) {
            String sortingMethod = UserInterface.askForSortingMethod();
            if (!sortingMethod.equals("4")) {
                SortingExecutor sortingExecutor = switch (sortingMethod) {
                    case "1" -> new SortingExecutor(new AllSortingMethod());
                    case "2" -> new SortingExecutor(new ByTypeSortingMethod());
                    case "3" -> new SortingExecutor(new CertainTypeSortingMethod());
                    default -> null;
                };
                if (sortingExecutor != null) {
                    sortingExecutor.execute(account);
                } else {
                    throw new RuntimeException("Invalid sorting method");
                }
            } else {
                break;
            }
        }
    }
}
