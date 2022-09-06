import java.util.ArrayList;
import java.util.HashMap;

public class ReportsCheck {
    ReadMonthlyReport readMonthlyReport = new ReadMonthlyReport();
    ReadYearlyReport readYearlyReport = new ReadYearlyReport();
    HashMap<Integer, ArrayList<MonthConstructor>> monthlyReportsMap = readMonthlyReport.readMonthlyReports();
    ArrayList<YearConstructor> yearlyReportsList = readYearlyReport.readYearlyReports();
    HashMap<Integer, Integer> yearExpenseList = new HashMap<>();
    HashMap<Integer, Integer> yearIncomeList = new HashMap<>();
    HashMap<Integer, Integer> monthExpenseList = new HashMap<>();
    HashMap<Integer, Integer> monthIncomeList = new HashMap<>();

    private void prepareYearReportsForCheck() {

    }


    private ArrayList<ReportsCheckConstructor> prepareMonthReportsForCheck(){
        ArrayList<ReportsCheckConstructor> values = new ArrayList<>();

        for (int month : monthlyReportsMap.keySet()) {
            int itemValueSumExp =0;
            int itemValueSumInc =0;
            ArrayList<MonthConstructor> items = monthlyReportsMap.get(month);
            for (MonthConstructor record : items) {
                int itemValue = record.quantity * record.sum_of_one;
                if(record.is_expense){
                    itemValueSumExp += itemValue;
                } else {
                    itemValueSumInc += itemValue;
                }
            }
            ReportsCheckConstructor putValuesExpenseTrue = new ReportsCheckConstructor(
                    month,
                    itemValueSumExp,
                    itemValueSumInc
            );
            values.add(putValuesExpenseTrue);
        }
        return values;
    }

    public void checkReports(){
        for (YearConstructor record : yearlyReportsList) { //привожу годовой отчет для сверки
            if (record.is_expense) {
                yearExpenseList.put(record.month, record.amount);
            } else {
                yearIncomeList.put(record.month, record.amount);
            }
        }
        for(ReportsCheckConstructor record: prepareMonthReportsForCheck()) {
                monthExpenseList.put(record.month, record.itemValueSumExp);
                monthIncomeList.put(record.month, record.itemValueSumInc);

            if (!yearExpenseList.get(record.month).equals(monthExpenseList.get(record.month))) {
                System.out.println("Расходы. Обнаружено несоотвествие данных в месяце:" + GetMonthName.getMonthName(record.month));
            } else {
                System.out.println("Сверка расходов за " + GetMonthName.getMonthName(record.month) + " выполнена успешно!");
            }

            if (!yearIncomeList.get(record.month).equals(monthIncomeList.get(record.month))) {
                System.out.println("Доходы. Обнаружено несоотвествие данных в месяце:" + GetMonthName.getMonthName(record.month));
            } else {
                System.out.println("Сверка доходов за " + GetMonthName.getMonthName(record.month) + " выполнена успешно!");
            }

            //System.out.println("Расходы: " + monthExpenseList + "|||" + yearExpenseList);
            //System.out.println("Доходы: " + monthIncomeList + "|||" + yearIncomeList);
        }
    }
}
