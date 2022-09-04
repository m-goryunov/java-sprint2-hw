import java.util.ArrayList;
import java.util.HashMap;

public class YearlyReport {
    ReadYearlyReport readYearlyReport = new ReadYearlyReport();
    ArrayList<YearConstructor> yearlyReportsList = readYearlyReport.readYearlyReports();
    HashMap<Integer, Integer> yearExpenseList = new HashMap<>();
    HashMap<Integer, Integer> yearIncomeList = new HashMap<>();

    public void GetProfitPerMonth() {
        for (YearConstructor record : yearlyReportsList) {
            if (record.is_expense) {
                yearExpenseList.put(record.month,record.amount);
            } else {
                yearIncomeList.put(record.month,record.amount);
            }
        }
        System.out.println("2021 год");
        int profit =0;
        for (int i = 1; i <= 3; i++) {
            profit = yearIncomeList.get(i) - yearExpenseList.get(i);
            System.out.println(GetMonthName.getMonthName(i) + ". Прибыль: " + profit);
        }
    }
    public void GetAvgIncomeAndExpense() {
        for (YearConstructor record : yearlyReportsList) {
            if (record.is_expense) {
                yearExpenseList.put(record.month,record.amount);
            } else {
                yearIncomeList.put(record.month,record.amount);
            }
        }
        int avgExpense = (yearExpenseList.get(1) + yearExpenseList.get(2) + yearExpenseList.get(3)) / yearExpenseList.size();
        System.out.println("Средний расход за все месяцы: " + avgExpense);
        int avgIncome = (yearIncomeList.get(1) + yearIncomeList.get(2) + yearIncomeList.get(3))/ yearIncomeList.size();
        System.out.println("Средний доход за все месяцы: " + avgIncome);
    }
}