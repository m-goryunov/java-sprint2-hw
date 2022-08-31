public class MonthConstructor {
    String itemName;
    boolean is_expense;
    int quantity;
    int sum_of_one;

    public MonthConstructor(String item_name, boolean is_expense, int quantity, int sum_of_one) {
        this.itemName = item_name;
        this.is_expense = is_expense;
        this.quantity = quantity;
        this.sum_of_one = sum_of_one;
    }

    @Override
    public String toString() {
        return "{" +
                "item_name='" + item_name + '\'' +
                ", is_expense=" + is_expense +
                ", quantity=" + quantity +
                ", sum_of_one=" + sum_of_one +
                '}';
    }
}
