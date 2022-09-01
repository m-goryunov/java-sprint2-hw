import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {

    ReadMonthlyReport readMonthlyReport = new ReadMonthlyReport();
    HashMap<Integer,ArrayList<MonthConstructor>> monthlyReportsMap = readMonthlyReport.monthlyReports();

    public void getMaxProfitItem(){

        for (int month: monthlyReportsMap.keySet()) {
            int maxProfitItem = 0;
            String maxProfitItemName = " ";
            ArrayList<MonthConstructor> items = monthlyReportsMap.get(month);
            for(MonthConstructor record: items) {
                if(!record.is_expense){
                    int tempProfitItem = record.quantity * record.sum_of_one;
                    if(tempProfitItem > maxProfitItem){
                            maxProfitItem = tempProfitItem;
                            maxProfitItemName = record.item_name;
                    }
                }
            }
            System.out.println(GetMonthName.getMonthName(month) + ". " + maxProfitItemName + " - " + maxProfitItem);
        }
    }
    public void getMaxExpense(){
        for (int month: monthlyReportsMap.keySet()) {
            int maxExpenseItem = 0;
            String maxExpenseItemName = " ";
            ArrayList<MonthConstructor> items = monthlyReportsMap.get(month);
            for(MonthConstructor record: items) {
                if(record.is_expense){
                    int findMaxExpenseItem = record.quantity * record.sum_of_one;
                    if(findMaxExpenseItem > maxExpenseItem){
                        maxExpenseItem = findMaxExpenseItem;
                        maxExpenseItemName = record.item_name;
                    }
                }
            }
            System.out.println(GetMonthName.getMonthName(month) + ". " + maxExpenseItemName + " - " + maxExpenseItem);
        }
    }

}