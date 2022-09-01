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
            ArrayList<MonthConstructor> list = monthlyReportsMap.get(month);
            for(MonthConstructor record: list){
                if(record.is_expense){
                    monthExpenseList.put(month,(record.sum_of_one * record.quantity));
                } else {
                    monthIncomeList.put(month,(record.sum_of_one * record.quantity));
                }
            }
        }
    }
    private HashMap<Integer, Integer> areEqualKeyValues(HashMap<Integer, Integer> yearExpenseList, HashMap<Integer, Integer> monthExpenseList) {
        return first.entrySet().stream()
                .collect(Collectors.toMap(e -> e.getKey(),
                        e -> e.getValue().equals(second.get(e.getKey()))));
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