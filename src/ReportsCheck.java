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
            int itemValueSum =0;
            ArrayList<MonthConstructor> items = monthlyReportsMap.get(month);
            for (MonthConstructor record : items) {
                int itemValue = record.quantity * record.sum_of_one;
                itemValueSum += itemValue;
                ReportsCheckConstructor putValues = new ReportsCheckConstructor(
                        month,
                        record.is_expense,
                        itemValueSum
                );
                values.add(putValues);
            }
            System.out.println(values);
            System.out.println("---------");
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
            if (record.is_expense) {
                monthExpenseList.put(record.month, record.itemValueSum);

            } else {
                monthIncomeList.put(record.month, record.itemValueSum);
            }

            System.out.println("Расходы: " + monthExpenseList + "|||" + yearExpenseList);
            System.out.println("Доходы: " + monthIncomeList + "|||" + yearIncomeList);
        }
           /* if (!yearExpenseList.get(record.month).equals(monthExpenseList.get(record.month))) {
                System.out.println("Расходы. Обнаружено несоотвествие данных в месяце:" + GetMonthName.getMonthName(record.month));
            } else {
                System.out.println("Сверка расходов за " + GetMonthName.getMonthName(record.month) + " выполнена успешно!");
            }

            if (!yearIncomeList.get(record.month).equals(monthIncomeList.get(record.month))) {
                System.out.println("Доходы. Обнаружено несоотвествие данных в месяце:" + GetMonthName.getMonthName(record.month));
            } else {
                System.out.println("Сверка доходов за " + GetMonthName.getMonthName(record.month) + " выполнена успешно!");
            }*/

    }

/*
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
            } else {
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
    }*/
}
