public class MonthReportConstructor {
    String item_name;
    int item_value;
    boolean is_expense;
    int month;

    public MonthReportConstructor(String item_name, int item_value, boolean is_expense, int month) {
        this.item_name = item_name;
        this.item_value = item_value;
        this.is_expense = is_expense;
        this.month = month;
    }

    @Override
    public String toString() {
        return "{" +
                "item_name='" + item_name + '\'' +
                ", item_value=" + item_value +
                ", is_expense=" + is_expense +
                ", month=" + month +
                '}';
    }
}
