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
            int amountExpense = 0;
            int amountSumExp = 0;
            ArrayList<MonthConstructor> list = monthlyReportsMap.get(month);
            for(MonthConstructor record: list) {
                if (record.is_expense) {
                    amountSumExp = record.sum_of_one * record.quantity;
                    amountExpense += amountSumExp;
                    monthExpenseList.put(month, amountExpense);
                }
            }
            if (yearExpenseList.get(month).equals(monthExpenseList.get(month)) == false){
                System.out.println("Обнаружено несоотвествие данных в месяце:" + GetMonthName.getMonthName(month));
            }else {
                System.out.println("Сверка расходов за " + GetMonthName.getMonthName(month) +  " выполнена успешно!");
            }
        }
        for(int month: monthlyReportsMap.keySet()) {
            int amountIncome = 0;
            int amountSumInc = 0;
            ArrayList<MonthConstructor> list = monthlyReportsMap.get(month);
            for (MonthConstructor recordd : list) {
                if (!recordd.is_expense) {
                    amountSumInc = recordd.sum_of_one * recordd.quantity;
                    amountIncome += amountSumInc;
                    monthIncomeList.put(month, amountIncome);
                    }
                }
            if (yearIncomeList.get(month).equals(monthIncomeList.get(month)) == false){
                System.out.println("Обнаружено несоотвествие данных в месяце:" + GetMonthName.getMonthName(month));
            } else {
                System.out.println("Сверка доходов за " + GetMonthName.getMonthName(month) +  " выполнена успешно!");
            }
        }
    }
}

//System.out.println(monthIncomeList +"|||" + monthExpenseList);
//System.out.println(yearIncomeList + "|||" + yearExpenseList);
//System.out.println(yearIncomeList.equals(monthIncomeList));
//System.out.println(yearExpenseList.equals(monthExpenseList));

/* При вызове сверки данных программа должна:
Подсчитывать две суммы: общие доходы и общие расходы по каждому из месяцев.

Сверять полученные суммы с суммой доходов и расходов в отчёте по году.

Если обнаружена ошибка, программа должна выводить месяц, в котором обнаружено несоответствие.

Если ошибок не обнаружено, должна выводиться только информация об успешном завершении операции.

Перед сверкой не забудьте проверить, что пользователь уже вызвал методы по считыванию обоих видов отчётов.
Для этого можно проверить значение отчётов на null, либо завести дополнительную приватную boolean переменную.
 */