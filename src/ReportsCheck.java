import java.util.ArrayList;
import java.util.HashMap;

public class ReportsCheck {
    ReadMonthlyReport readMonthlyReport = new ReadMonthlyReport();
    ReadYearlyReport readYearlyReport = new ReadYearlyReport();
    HashMap<Integer, ArrayList<MonthConstructor>> monthlyReportsMap = readMonthlyReport.monthlyReports();
    ArrayList<YearConstructor> yearlyReportsList = readYearlyReport.yearlyReports();
    HashMap<Integer, Integer> yearExpenseList = new HashMap<>();
    HashMap<Integer, Integer> yearIncomeList = new HashMap<>();
    HashMap<Integer, Integer> monthExpenseList = new HashMap<>();
    HashMap<Integer, Integer> monthIncomeList = new HashMap<>();

    public void reportsCheck(){
        for (YearConstructor record : yearlyReportsList) {
            if (record.is_expense) {
                yearExpenseList.put(record.month,record.amount);
            } else {
                yearIncomeList.put(record.month,record.amount);
            }
        }

        for(int month: monthlyReportsMap.keySet()){
            int amountIncome = 0;
            int amountExpense = 0;
            int amountSum = 0;
            ArrayList<MonthConstructor> list = monthlyReportsMap.get(month);
            for(MonthConstructor record: list){
                amountSum = record.sum_of_one * record.quantity;
                amount += amountSum; // Пытаюсь проссумировать
                if(record.is_expense){
                    monthExpenseList.put(month,amount);
                } else {
                    monthIncomeList.put(month,amount);
                }
            }
            System.out.println(monthIncomeList);
            System.out.println("========");
        }
        System.out.println(monthIncomeList +"|||" + monthExpenseList);
        System.out.println(yearIncomeList + "|||" + yearExpenseList);
        System.out.println(yearIncomeList.equals(monthIncomeList));
        System.out.println(yearExpenseList.equals(monthExpenseList));
    }
}

/* При вызове сверки данных программа должна:
Подсчитывать две суммы: общие доходы и общие расходы по каждому из месяцев.

Сверять полученные суммы с суммой доходов и расходов в отчёте по году.

Если обнаружена ошибка, программа должна выводить месяц, в котором обнаружено несоответствие.

Если ошибок не обнаружено, должна выводиться только информация об успешном завершении операции.

Перед сверкой не забудьте проверить, что пользователь уже вызвал методы по считыванию обоих видов отчётов.
Для этого можно проверить значение отчётов на null, либо завести дополнительную приватную boolean переменную.
 */