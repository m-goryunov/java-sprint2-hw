import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {

    ArrayList<MonthConstructor> recordList;
    public MonthlyReport(ArrayList<MonthConstructor> recordList) {
        this.recordList = recordList;
    }


    public void getMostProfitItem(ArrayList<MonthConstructor> recordList){
        MonthlyReport month = new MonthlyReport(recordList);
        CreateMonthReport createMonthReport = new CreateMonthReport();

    }



}

//Что нужно:
// По каждому месяцу
//Название месяца;
//Самый прибыльный товар, то есть товар для которого is_expense == false,
// а произведение количества (quantity) на сумму (sum_of_one) максимально. Вывести название товара и сумму;
//Самую большую трату. Вывести название товара и сумму.