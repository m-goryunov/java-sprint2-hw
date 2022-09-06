import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {

    ReadMonthlyReport readMonthlyReport = new ReadMonthlyReport();
    HashMap<Integer, ArrayList<MonthConstructor>> monthlyReportsMap = readMonthlyReport.readMonthlyReports();

    private ArrayList<MonthReportConstructor> findExpenseAndProfits() {
        ArrayList<MonthReportConstructor> values = new ArrayList<>();
        for (int month : monthlyReportsMap.keySet()) {
            ArrayList<MonthConstructor> items = monthlyReportsMap.get(month);
            for (MonthConstructor record : items) {
                int itemValue = record.quantity * record.sum_of_one;
                MonthReportConstructor putValues = new MonthReportConstructor(
                        record.item_name,
                        itemValue,
                        record.is_expense,
                        month
                );
                values.add(putValues);
            }
        }
        return values;
    }

    public void getMaxProfitItem() {
        for (int i = 1; i <= 3; i++) {
            int maxProfitItem = 0;
            String maxProfitItemName = " ";

            for (MonthReportConstructor record : findExpenseAndProfits()) {
                if (record.month == i && !record.is_expense) {
                    if (record.item_value > maxProfitItem) {
                        maxProfitItem = record.item_value;
                        maxProfitItemName = record.item_name;
                    }
                }
            }
            System.out.println(GetMonthName.getMonthName(i) + ". " + maxProfitItemName + " - " + maxProfitItem);
        }
    }

    public void getMaxExpense() {
        for (int i = 1; i <= 3; i++) {
            int maxExpenseItem = 0;
            String maxExpenseItemName = " ";
            for (MonthReportConstructor record : findExpenseAndProfits()) {
                if (record.month == i && record.is_expense) {
                    if (record.item_value > maxExpenseItem) {
                        maxExpenseItem = record.item_value;
                        maxExpenseItemName = record.item_name;
                    }
                }
            }
            System.out.println(GetMonthName.getMonthName(i) + ". " + maxExpenseItemName + " - " + maxExpenseItem);
        }
    }
}