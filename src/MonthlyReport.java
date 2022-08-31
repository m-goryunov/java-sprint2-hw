import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

public class MonthlyReport {

    CreateMonthReport createMonthReport = new CreateMonthReport();
    HashMap<Integer,ArrayList<MonthConstructor>> monthlyReportsMap = createMonthReport.monthlyReports();

    public void getMostProfitItem(){
        ArrayList<MonthConstructor> findMaxExpense = monthlyReportsMap.get(1);

        for (int month: monthlyReportsMap.keySet()) {
            ArrayList<MonthConstructor> items = monthlyReportsMap.get(month);

            for (int i = 0; i< items.stream().count(); i++) {
                MonthConstructor c = items.get(i);
                        c.
            }
            for(MonthConstructor c: items) {
                if(c.is_expense == true){
                    c.
                }
            }

            MonthConstructor c = items.stream().filter(item -> item.is_expense == false)[0];

        }
        for (int i = 1; i < findMaxExpense.size(); i++) {

        }


    }
}

//Что нужно:
// По каждому месяцу
//Название месяца;
//Самый прибыльный товар, то есть товар для которого is_expense == false,
// а произведение количества (quantity) на сумму (sum_of_one) максимально. Вывести название товара и сумму;
//Самую большую трату. Вывести название товара и сумму.