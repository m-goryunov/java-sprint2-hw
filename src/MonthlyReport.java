import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {

    CreateMonthReport createMonthReport = new CreateMonthReport();
    HashMap<Integer,ArrayList<MonthConstructor>> monthlyReportsMap = createMonthReport.monthlyReports();

    public void getMaxProfitItem(){
        for (int month: monthlyReportsMap.keySet()) {
            int maxProfitSum = 0;
            String maxProfitItemName = " ";
            ArrayList<MonthConstructor> items = monthlyReportsMap.get(month);
            for(MonthConstructor record: items) {
                if(!record.is_expense){
                    int tempProfitSum = record.quantity * record.sum_of_one;
                    if(tempProfitSum > maxProfitSum){
                            maxProfitSum = tempProfitSum;
                            maxProfitItemName = record.item_name;
                    }
                }
            }
            System.out.println(GetMonthName.getMonthName(month) + ". " + maxProfitItemName + " - " + maxProfitSum);
        }
    }
}

//Что нужно:
// По каждому месяцу
//Название месяца;
//Самый прибыльный товар, то есть товар для которого is_expense == false,
// а произведение количества (quantity) на сумму (sum_of_one) максимально. Вывести название товара и сумму;
//Самую большую трату. Вывести название товара и сумму.