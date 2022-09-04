import java.util.ArrayList;
import java.util.HashMap;

public class ReportsCheck {
    ReadMonthlyReport readMonthlyReport = new ReadMonthlyReport();
    ReadYearlyReport readYearlyReport = new ReadYearlyReport();
    HashMap<Integer, ArrayList<MonthConstructor>> monthlyReportsMap = readMonthlyReport.readMonthlyReports();
    ArrayList<YearConstructor> yearlyReportsList = readYearlyReport.readYearlyReports();
    HashMap<Integer, Integer> yearExpenseList = new HashMap<>(); //новые типовые хэшмамы для проведения сверки
    HashMap<Integer, Integer> yearIncomeList = new HashMap<>();
    HashMap<Integer, Integer> monthExpenseList = new HashMap<>();
    HashMap<Integer, Integer> monthIncomeList = new HashMap<>();
    //Прошу не бить за этот класс. Представляю, что скорее всего можно было на много лаконичнее сделать..

    public void reportsCheck(){
        for (YearConstructor record : yearlyReportsList) { //привожу годовой отчет для сверки
            if (record.is_expense) {
                yearExpenseList.put(record.month,record.amount);
            } else {
                yearIncomeList.put(record.month,record.amount);
            }
        }

        for(int month: monthlyReportsMap.keySet()){ //привожу месячный и сверяю расходы
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
        for(int month: monthlyReportsMap.keySet()) { //привожу месячный и сверяю доходы
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
