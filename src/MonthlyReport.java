import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {

    ArrayList<MonthConstructor> recordList;


    public MonthlyReport(ArrayList<MonthConstructor> recordList) {
        this.recordList = recordList;

    }

    public void getMostProfitItem(){
        MonthConstructor monthConstructor = new MonthConstructor();
        CreateMonthReport findMostProfitableItem = new CreateMonthReport();
        if (!monthConstructor.is_expense){
            int quantityMultiplyToSumOfOne = monthConstructor.quantity * monthConstructor.sum_of_one
        }
    }
}
