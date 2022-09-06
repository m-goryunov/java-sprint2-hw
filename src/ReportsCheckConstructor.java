public class ReportsCheckConstructor {
    int month;
    boolean is_expense;
    int itemValueSum;

    public ReportsCheckConstructor(int month, boolean is_expense, int itemValueSum) {
        this.month = month;
        this.is_expense = is_expense;
        this.itemValueSum = itemValueSum;
    }

    @Override
    public String toString() {
        return "{" +
                "month=" + month +
                ", is_expense=" + is_expense +
                ", itemValueSum=" + itemValueSum +
                '}';
    }
}