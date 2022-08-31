public class YearConstructor {
    int month;
    int amount;
    boolean is_expense;

    public YearConstructor(int month, int amount, boolean is_expense) {
        this.month = month;
        this.amount = amount;
        this.is_expense = is_expense;
    }

    @Override
    public String toString() {
        return "{" +
                "month=" + month +
                ", amount=" + amount +
                ", is_expense=" + is_expense +
                '}';
    }
}
